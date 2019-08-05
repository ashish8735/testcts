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
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Services.MstApplicationService;

@RestController
@RequestMapping("/mstApplication")
public class MstApplicationController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstApplicationService mstApplicationService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstApplication mstApplication) {
		if (mstApplication.getApplicationName() != null) {
			mstApplicationService.save(mstApplication);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstApplication> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "appId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstApplicationService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstApplicationService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("byid/{appId}")
	public MstApplication read(@PathVariable("appId") Long appId) {
		MstApplication objMstApplication = mstApplicationService.findOneById(appId);
		return objMstApplication;
	}

	@PutMapping("delete/{appId}")
	public Map<String, String> delete(@PathVariable("appId") Long appId) {
		if (appId != 0) {
			mstApplicationService.deleteById(appId);
			respMap.put("msg", "Operation Successful");
			respMap.put("success", "1");
		} else {
			respMap.put("msg", "Operation Failed");
			respMap.put("success", "0");
		}
		return respMap;
	}

	@RequestMapping("export")
	public ResponseEntity<InputStreamResource> export() throws IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=Application.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.attendenceToExcel("mst_application")));

	}

	@RequestMapping("customeExport")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "select a.application_id,a.abbreviation_name,a.application_name,a.description,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_application a";
		String headerNames = "Application Id,Abbreviation Name,Application Name,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=Application.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Application")));

	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("listByIsActive")
	public Iterable<MstApplication> listByIsActive(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "appId") String col) {

		return mstApplicationService.findAllRecordsByIsActive(new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size), Sort.Direction.fromString(sort), col));

	}

}
