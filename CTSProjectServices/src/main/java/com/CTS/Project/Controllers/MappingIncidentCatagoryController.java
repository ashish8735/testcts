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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MappingIncidentCatagory;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Services.MappingIncidentCategoryService;

@RestController
@RequestMapping("/mappingIncedentCatagory")
public class MappingIncidentCatagoryController {

	@Autowired
	MappingIncidentCategoryService mappingIncidentCategoryService;

	@Autowired
	ExcelGenerator excelGenerator;

	Map<String, String> respMap = new HashMap<String, String>();

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MappingIncidentCatagory mappingIncidentCategory) {
		if (mappingIncidentCategory.getMicApplicationId().getAppId() != 0) {
			mappingIncidentCategoryService.save(mappingIncidentCategory);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}

	@RequestMapping("byid/{mapincidentCatagoryId}")
	public MappingIncidentCatagory read(@PathVariable("mapincidentCatagoryId") Long mapincidentCatagoryId) {
		MappingIncidentCatagory objMappingIncidentCatagory = mappingIncidentCategoryService
				.findOneById(mapincidentCatagoryId);

		return objMappingIncidentCatagory;
	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MappingIncidentCatagory> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "mapincidentCatagoryId") String col) {

		if (searchString == null || searchString.equals("")) {
			
			return mappingIncidentCategoryService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mappingIncidentCategoryService.compliteSearch(searchString, new PageRequest(
					Integer.parseInt(page) - 1, Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	/*
	 * @PutMapping("delete/{mapincidentCatagoryId}") public Map<String, String>
	 * delete(@PathVariable("mapincidentCatagoryId") Long applicationTimingId) { if
	 * (applicationTimingId != 0) {
	 * mappingIncidentCategoryService.deleteById(mapincidentCatagoryId);
	 * respMap.put("msg", "Operation Successful"); respMap.put("success", "1"); }
	 * else { respMap.put("msg", "Operation Failed"); respMap.put("success", "0"); }
	 * return respMap; }
	 */

	@RequestMapping("customeExport")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "select p.mapincident_catagory_id,a.application_name,ic.incidentcategory_name,(case when (CAST(p.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_map_incident_category p inner join mst_application a on p.mic_application_id=a.application_id " + 
				"inner join mst_incident_category ic on p.mic_incidentcategory_id=ic.incidentcategory_id ";
		String headerNames = "Id,Application Name,Incident Category Name,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=MappingIncidentCategory.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(
				excelGenerator.createCustoneExcel(headerNames, query, "MappingIncidentCategory")));

	}
	@GetMapping("getIncidentCategory/{app_id}")
	public List<MappingIncidentCatagory> getIncidentCategory(@PathVariable("app_id") long app_id)
	{
		System.out.println("testttttttttt"+app_id);
		List<MappingIncidentCatagory> Categorylist=mappingIncidentCategoryService.getIncidentCategory(app_id);
		
		return Categorylist;
	} 

}
