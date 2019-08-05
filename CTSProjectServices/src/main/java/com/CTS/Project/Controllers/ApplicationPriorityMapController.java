package com.CTS.Project.Controllers;

import java.io.IOException;
import java.util.HashMap;
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

import com.CTS.Project.Models.ApplicationPriorityMap;
import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Services.ApplicationPriorityMapService;

@RestController
@RequestMapping("/mstApplicationPriorityMap")
public class ApplicationPriorityMapController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	ApplicationPriorityMapService appPriorityService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody ApplicationPriorityMap prioritymap) {
		ApplicationPriorityMap obj = appPriorityService.checkExist(prioritymap.getMapApplicationId().getAppId(),
				prioritymap.getMapPriorityId().getPriorityId());
		if (obj == null) {
			if (prioritymap.getMapApplicationId().getAppId() != 0) {
				appPriorityService.save(prioritymap);
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
			respMap.put("msg", "Record already exist");
			return respMap;

		}
	}


	@RequestMapping("byid/{applicationPriorityID}")
	public ApplicationPriorityMap read(@PathVariable("applicationPriorityID") Long applicationPriorityID) {
		System.out.println("------------------" + applicationPriorityID);
		ApplicationPriorityMap objPriority = appPriorityService.findOneById(applicationPriorityID);
		return objPriority;
	}

	@PutMapping("delete/{applicationPriorityID}")
	public Map<String, String> delete(@PathVariable("applicationPriorityID") Long applicationPriorityID) {

		if (applicationPriorityID != 0) {
			appPriorityService.deleteById(applicationPriorityID);
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

		String query = "select a.application_name,p.priority_name,ar.configure_order,(case when (CAST(ar.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END)  from mapping_application_priority ar inner join mst_application a on ar.map_application_id=a.application_id inner join mst_priority p on ar.map_priority_id=p.priority_id";
		String headerNames = "Application Name,Priority Name,Configue Order,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ApplicationPriorityMap.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(
				excelGenerator.createCustoneExcel(headerNames, query, "ApplicationPriorityMap")));

	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<ApplicationPriorityMap> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "searchInt", required = false) Integer searchInt,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "applicationPriorityID") String col) {

		if (searchString == null || searchString.equals("")) {
			return appPriorityService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
					Sort.Direction.fromString(sort), col));

		} else {

			return appPriorityService.completeSearch(searchString, searchInt, new PageRequest(
					Integer.parseInt(page) - 1, Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}
}
