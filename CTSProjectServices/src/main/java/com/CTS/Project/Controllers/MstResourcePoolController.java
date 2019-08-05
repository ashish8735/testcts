package com.CTS.Project.Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Services.MstResourcePoolService;

@RestController
@RequestMapping("/mstResourcePool")
public class MstResourcePoolController {
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstResourcePoolService resourcePoolService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstResourcePool resource) {
		if (resource.getResourceName() != null) {
			resourcePoolService.save(resource);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}

	@RequestMapping("byid/{resourceId}")
	public MstResourcePool read(@PathVariable("resourceId") Long resourceId) {
		MstResourcePool objResourcePool = resourcePoolService.findOneById(resourceId);
		return objResourcePool;
	}

	@PutMapping("delete/{resourceId}")
	public Map<String, String> delete(@PathVariable("resourceId") Long resourceId) {
		if (resourceId != 0) {
			resourcePoolService.deleteById(resourceId);
			respMap.put("msg", "Operation Successful");
			respMap.put("success", "1");
		} else {
			respMap.put("msg", "Operation Failed");
			respMap.put("success", "0");
		}
		return respMap;
	}

	@RequestMapping("customeExport")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "select rp.resource_id,rp.resource_name,rp.loginid,rp.dealer_code,rp.branch_name,rd.resource_designation_name,rp.email_id,rp.mobile_no,(case when (CAST(rp.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_resource_pool rp inner join resource_designation_id di on rp.rp_resource_designation_type_id=di.resource_designation_id_resource_designation_id inner join mst_resource_designation rd on  rd.resource_designation_id=di.resource_designation_id_resource_designation_id";
		String headerNames = "Resource Id,Resource Name, Login Id,Dealer Code,Branch Name,Designation Name,Email Id,Mobile No,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ResourcePool.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "ResourcePool")));

	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstResourcePool> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceId") String col) {

		if (searchString == null || searchString.equals("")) {
			return resourcePoolService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return resourcePoolService.completeSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}
	}

	@RequestMapping("lid/{id}")
	public Boolean read(@PathVariable("id") String id) {
		MstResourcePool objResourcePool = resourcePoolService.findByLoginId(id);
		if (objResourcePool != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("appResourcelist/{id}")
	public List<MstResourcePool> getListOfMstResource(@PathVariable Long id)
	{
		System.out.println(id+"------------------------------");
		List<MstResourcePool> stagelist=resourcePoolService.getAllApplicationResource(id);
		
		return stagelist;
	}

	@RequestMapping("updatePassword")
	public Map<String, String> Resourceupdate(@RequestBody List<MstResourcePool> mst) {
		try {
			resourcePoolService.save(mst);
			respMap.put("msg", "Updated Successful");
			respMap.put("success", "1");
		} catch (Exception e) {
			respMap.put("msg", "Updation Failed");
			respMap.put("success", "0");
		}
		return respMap;
	}
	@RequestMapping("getResourcebyId/{id}")
	public MstResourcePool getResourcePoolById(@PathVariable("id") Long id) {
		System.out.println(id+"---------------------------");
		MstResourcePool objResourcePool = resourcePoolService.findByresourceId(id);
		return objResourcePool;
	} 
	
	
	@GetMapping("UpperLevellist/{app_id}/{stage_id}")
	public List<ResourceRoleMap> getUpperLevels(@PathVariable Long app_id,@PathVariable Long stage_id)
	{
		System.out.println(app_id+"------------------------------");
		List<ResourceRoleMap> levellist=resourcePoolService.getUpperLevelResource(app_id,stage_id);
		
		return levellist;
	} 
	@GetMapping("SameLevellist/{app_id}/{stage_id}")
	public List<ResourceRoleMap> getSameLevels(@PathVariable Long app_id,@PathVariable Long stage_id)
	{
		System.out.println(app_id+"------------------------------");
		List<ResourceRoleMap> levellist=resourcePoolService.getSameLevelResource(app_id,stage_id);
		
		return levellist;
	} 
}
