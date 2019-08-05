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

import com.CTS.Project.Models.ApplicationTiming;
import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Services.ApplicationTimingService;


@RestController
@RequestMapping("/applicationTimingController")
public class ApplicationTimingController 
{

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	ApplicationTimingService applicationTimingService;
	
	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody ApplicationTiming applicationtiming) {
		System.out.println("inside create==" + applicationtiming.getApplicationTimingId());
//		if (applicationtiming.getApplicationTimingId()== null)
//		{
			applicationTimingService.save(applicationtiming);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
//		} else {
//			respMap.put("success", "0");
//			respMap.put("msg", "Failed To Add Null Field");
//			return respMap;
//		}
	}
	
	
	@RequestMapping("byid/{applicationtimingId}")
	public ApplicationTiming read(@PathVariable("applicationtimingId") Long applicationtimingId) {
		ApplicationTiming objApplicationTiming = applicationTimingService.findOneById(applicationtimingId);
		
		return objApplicationTiming;
	}

	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<ApplicationTiming> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "applicationTimingId") String col) {
		

		if (searchString == null || searchString.equals("")) {
			return applicationTimingService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return applicationTimingService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

		
	@PutMapping("delete/{applicationtimingId}")
	public Map<String, String> delete(@PathVariable("applicationTimingId") Long applicationTimingId) {
		if (applicationTimingId != 0) {
			applicationTimingService.deleteById(applicationTimingId);
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

		String query = "select a.application_name,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as sunday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as monday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as tuesday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as wednesday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as thursday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as friday,(case when (a.is_active = 1) THEN 'True' ELSE 'False' END) as saturday,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_application_timing at inner join mst_application a on at.mst_application_Id=a.application_id";
		String headerNames = "Application Name,Sunday,Monday,Tuesday,wednesday,Thursday,Friday,Saturday,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ApplicationTiming.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "ApplicationTiming")));

	}

	
	
	
	
}
