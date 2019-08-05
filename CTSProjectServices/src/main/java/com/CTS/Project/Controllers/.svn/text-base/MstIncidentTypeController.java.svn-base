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
import com.CTS.Project.Models.MstIncidentType;
import com.CTS.Project.Services.MstIncidentTypeService;

@RestController
@RequestMapping("/mstIncidentType")
public class MstIncidentTypeController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstIncidentTypeService mstIncidentTypeService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstIncidentType mstIncidentType) {
		if (mstIncidentType.getIncidentTypeName() != null) {
			mstIncidentTypeService.save(mstIncidentType);
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
	public Iterable<MstIncidentType> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentTypeId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstIncidentTypeService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstIncidentTypeService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("byid/{appId}")
	public MstIncidentType read(@PathVariable("appId") Long appId) {
		MstIncidentType objMstIncidentType = mstIncidentTypeService.findOneById(appId);
		return objMstIncidentType;
	}

	@PutMapping("delete/{appId}")
	public Map<String, String> delete(@PathVariable("appId") Long appId) {
		if (appId != 0) {
			mstIncidentTypeService.deleteById(appId);
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

		String query = "select it.incident_type_id,a.application_name,it.incident_type_name,it.description,(case when (CAST(it.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_incedent_type it inner join mst_application a on it.incident_type_application_id=a.application_id ";
		String headerNames = "Incident Type Id,Application Name,Incident Type,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=IncidentType.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "IncidentType")));

	}
	
	@RequestMapping("getByApplicationId")
	public List<MstIncidentType> getRecordByAppliactionId(@RequestParam(value = "appId") long appId) {
		return mstIncidentTypeService.getAllRecordByApplicationId(appId);
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("listByIsActive")
	public Iterable<MstIncidentType> listByIsActive(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentTypeId") String col) {

		return mstIncidentTypeService.findAllRecordsByIsActive(new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size), Sort.Direction.fromString(sort), col));

	}
	
	@RequestMapping(value="incidentByappId/{id}")
	public List<MstIncidentType> getIncidentByAppId(@PathVariable Long id)
	{
		List<MstIncidentType> list=mstIncidentTypeService.getAllRecordByApplicationId(id);
		return list;
		
	}
}
