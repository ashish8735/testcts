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

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.IncidentCategory;
import com.CTS.Project.Services.IncidentCategoryService;


@RestController
@RequestMapping("/incident_Category")
public class IncedentCategoryController 
{

	
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	IncidentCategoryService incidentCategoryService;
	
	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody IncidentCategory incidentCategory) {
		if (incidentCategory.getIncidentcategoryName() != null) {
			incidentCategoryService.save(incidentCategory);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}
	
	
	@RequestMapping("byid/{incidentcategoryId}")
	public IncidentCategory read(@PathVariable("incidentcategoryId") Integer incidentcategoryId) {
		IncidentCategory objIncidentCategory = incidentCategoryService.findOneById(incidentcategoryId);
		
		return objIncidentCategory;
	}

	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<IncidentCategory> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentcategoryId") String col) {

		if (searchString == null || searchString.equals("")) {
			return incidentCategoryService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return incidentCategoryService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	
	
	
	@PutMapping("delete/{incidentcategoryId}")
	public Map<String, String> delete(@PathVariable("incidentcategoryId") Integer incidentcategoryId) {
		if (incidentcategoryId != 0) {
			incidentCategoryService.deleteById(incidentcategoryId);
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

		String query = "select at.incidentcategory_id,at.incidentcategory_name,at.description, (case when (CAST(at.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_incident_Category at";
		String headerNames = "Incidentcategory Id,Incidentcategory Name,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=IncidentCategory.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "IncidentCategory")));

	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("listByIsActive")
	public Iterable<IncidentCategory> listByIsActive(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentcategoryId") String col) {
		return incidentCategoryService.findAllRecordsByIsActive(new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size), Sort.Direction.fromString(sort), col));

	}
	
	
}
