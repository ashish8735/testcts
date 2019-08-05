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
import com.CTS.Project.Models.MstAppicationRoleMap;
import com.CTS.Project.Services.MstAppicationRoleMapService;

@RestController
@RequestMapping("/mstAppicationRoleMap")
public class MstAppicationRoleMapController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstAppicationRoleMapService mstAppicationRoleMapService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstAppicationRoleMap mstAppicationRoleMap) {
		MstAppicationRoleMap obj = mstAppicationRoleMapService.checkRecordExists(
				mstAppicationRoleMap.getApplicationMapApplicationId().getAppId(),
				mstAppicationRoleMap.getApplicationMapRoleId().getRoleId());
		if (obj == null) {
			if (mstAppicationRoleMap.getApplicationMapApplicationId() != null) {
				mstAppicationRoleMapService.save(mstAppicationRoleMap);
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

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstAppicationRoleMap> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "appilicationRoleId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstAppicationRoleMapService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstAppicationRoleMapService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("byid/{appilicationRoleId}")
	public MstAppicationRoleMap read(@PathVariable("appilicationRoleId") Long appilicationRoleId) {
		MstAppicationRoleMap objMstAppicationRoleMap = mstAppicationRoleMapService.findOneById(appilicationRoleId);
		return objMstAppicationRoleMap;
	}

	@PutMapping("delete/{appilicationRoleId}")
	public Map<String, String> delete(@PathVariable("appilicationRoleId") Long appilicationRoleId) {
		if (appilicationRoleId != 0) {
			mstAppicationRoleMapService.deleteById(appilicationRoleId);
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

		String query = "select ar.application_map_application_id,a.application_name,r.role_name,(case when (CAST(ar.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_appication_role_map ar inner join mst_application a on ar.application_map_application_id=a.application_id inner join mst_role r on ar.application_map_role_id=r.role_id ";
		String headerNames = "Map Application Role Id,Application Name,Role Name,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ApplicationRoleMap.xlsx");
		return ResponseEntity.ok().headers(headers).body(
				new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "ApplicationRoleMap")));

	}
	
	@PutMapping("getRecordByRoleId/{roleId}")
	public List<MstAppicationRoleMap> getRecordByRoleId(@PathVariable("roleId") Long roleId) {
		return mstAppicationRoleMapService.getListByRoleId(roleId);
	}
	
	@RequestMapping("getListByResourceType/{id}")
	public List<MstAppicationRoleMap> getListByResourceType(@PathVariable("id") Long id) {
		return mstAppicationRoleMapService.getListByResourceType(id);
	}

}
