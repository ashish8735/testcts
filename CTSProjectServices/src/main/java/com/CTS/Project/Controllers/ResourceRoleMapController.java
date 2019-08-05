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
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Services.ResourceRoleMapService;

@RestController
@RequestMapping("/mstResourceRoleMap")
public class ResourceRoleMapController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	ResourceRoleMapService rrm;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("/create")
	public Map<String, String> create(@RequestBody ResourceRoleMap mstresourceRoleMap) {
		
		ResourceRoleMap obj = rrm.checkUniqueRecord(mstresourceRoleMap.getMtApplicationId().getAppId(),
				mstresourceRoleMap.getmResourceId().getResourceId(), mstresourceRoleMap.getMtRoleId().getRoleId());
		
		if (obj == null) {
			if (mstresourceRoleMap.getMtApplicationId().getAppId() != 0) {
				rrm.save(mstresourceRoleMap);
				respMap.put("success", "1");
				respMap.put("msg", "Process Completed Successfully");
				return respMap;
			} else {
				respMap.put("success", "0");
				respMap.put("msg", "Failed To Add Null Field");
				return respMap;
			}
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Record Already Exist.");
			return respMap;
		}

	}

	@PutMapping("delete/{resourceRoleID}")
	public Map<String, String> deleteById(@PathVariable Long resourceRoleID) {
		if (resourceRoleID != 0) {
			rrm.deleteById(resourceRoleID);
			respMap.put("success", "1");
			respMap.put("msg", "Removed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Delete Null Field");
			return respMap;
		}
	}

	@RequestMapping("byid/{resourceId}")
	public ResourceRoleMap read(@PathVariable("resourceRoleID") String resourceRoleID) {
		ResourceRoleMap obj = rrm.findOneById(resourceRoleID);
		return obj;
	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<ResourceRoleMap> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,

			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceRoleID") String col) {

		if (searchString == null || searchString.equals("")) {
			return rrm.findAllRecords(new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
					Sort.Direction.fromString(sort), col));

		} else {

			return rrm.completeSearch(searchString, new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
					Sort.Direction.fromString(sort), col));

		}
	}

	@GetMapping("applicationlist")
	public List<MstApplication> getListOfMstapplication() {
		List<MstApplication> mstapplicationlist = rrm.getMstApplication();

		return mstapplicationlist;
	}

	@GetMapping("resourcebyid/{resourceid}")
	public List<MstResourcePool> getresourcepoolByid(@PathVariable(value = "resourceid") Long resourceid) {
		List<MstResourcePool> resourcelist = rrm.getMstResourcepoolById(resourceid);
		return resourcelist;
	}

	@GetMapping("resourcetypelist")
	public List<MstResourceType> getListOfResourcetype() {
		List<MstResourceType> mstresourcetypelist = rrm.getresourceTypeList();

		return mstresourcetypelist;
	}

	@GetMapping("rolelist")
	public List<MstRole> getmstrole() {
		List<MstRole> rolelist = rrm.getMstRoleList();
		return rolelist;
	}

	@RequestMapping("customeExport")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "select rp.resource_name,a.application_name,r.role_name,(case when (CAST(mr.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mapping_resourcerole mr inner join mst_resource_pool rp on mr.mst_resource_id=rp.resource_id "
				+ "inner join mst_application a on mr.mst_application_id=a.application_id inner join mst_role r on mr.mst_role_id=r.role_id ";
		String headerNames = "Resource Name,Application Name,Role Name,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ResourceRoleMap.xlsx");
		return ResponseEntity.ok().headers(headers).body(
				new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "ResourceRoleMap")));

	}
	
	@GetMapping("getRsourceListByAppId")
	public List<ResourceRoleMap> getRsourceListByAppId(@RequestParam(value = "appId") long appId,@RequestParam(value = "typeId") long typeId) {
		List<ResourceRoleMap> resorceRoleMaplist = rrm.getResourceListByAppId(appId,typeId);
		return resorceRoleMaplist;
	}
}
