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
import com.CTS.Project.Models.MstIncidentSubType;
import com.CTS.Project.Services.MstIncidentSubTypeService;

@RestController
@RequestMapping("/mstIncidentSubType")
public class MstIncidentSubTypeController {
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstIncidentSubTypeService mstIncidentSubTypeService;

	@Autowired
	ExcelGenerator excelGenerator;

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstIncidentSubType mstIncidentSubType) {
		if (mstIncidentSubType.getIncidentSubTypeName() != null) {
			mstIncidentSubTypeService.save(mstIncidentSubType);
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
	public Iterable<MstIncidentSubType> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentSubTypeId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstIncidentSubTypeService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstIncidentSubTypeService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("byid/{appId}")
	public MstIncidentSubType read(@PathVariable("appId") Long appId) {
		MstIncidentSubType objMstIncidentSubType = mstIncidentSubTypeService.findOneById(appId);
		return objMstIncidentSubType;
	}

	@PutMapping("delete/{appId}")
	public Map<String, String> delete(@PathVariable("appId") Long appId) {
		if (appId != 0) {
			mstIncidentSubTypeService.deleteById(appId);
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

		String query = "select st.incident_sub_type_id,a.application_name,t.incident_type_name,st.incident_sub_type_name,st.description,(case when (CAST(st.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_incedent_sub_type st " + 
				" inner join mst_incedent_type t on st.incident_sub_type_incidence_id=t.incident_type_id inner join mst_application a on t.incident_type_application_id=a.application_id ";
		String headerNames = "Incident Sub Type Id,Application Name,Incident Type,Incident Sub Type Name,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=IncidentSubType.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "IncidentSubType")));

	}
	
	@RequestMapping("getByIncidentTypeId")
	public List<MstIncidentSubType> getRecordByIncidentId(@RequestParam(value = "incidentTypeId") long incidentTypeId) {
		return mstIncidentSubTypeService.getAllRecordByIncidentTypeId(incidentTypeId);
	}

}
