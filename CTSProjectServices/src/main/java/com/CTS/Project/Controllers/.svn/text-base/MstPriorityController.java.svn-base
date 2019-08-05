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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MstPriority;
import com.CTS.Project.Services.MstPriorityService;

@RestController
@RequestMapping("/mstPriority")
public class MstPriorityController {

	@Autowired
	MstPriorityService mstpriorityservice;

	@Autowired
	ExcelGenerator excelGenerator;

	Map<String, String> respMap = new HashMap<String, String>();

	/* Add priority */
	@PostMapping("/add")
	public Map<String, String> addpriority(@RequestBody MstPriority mstpriority) {
		if (mstpriority.getPriorityName() != "" & mstpriority.getDescription() != "") {
			mstpriorityservice.save(mstpriority);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}

	}

	/* Delete priority By ID */
	@GetMapping("delete/{priorityId}")
	public Map<String, String> deleteById(@PathVariable Long priorityId) {
		if (priorityId != 0) {
			mstpriorityservice.deleteById(priorityId);
			respMap.put("success", "1");
			respMap.put("msg", "Removed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Delete Null Field");
			return respMap;
		}
	}

	/* Get data By Id */
	@GetMapping("editpriority/{Id}")
	public MstPriority editById(@PathVariable Long Id) {
		MstPriority list = mstpriorityservice.findById(Id);
		return list;

	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstPriority> list(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "priorityId") String col) {

		if (searchString == null || searchString.equals("")) {
			System.out.println();
			return mstpriorityservice.findAllRecords(new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
					Sort.Direction.fromString(sort), col));

		} else {

			return mstpriorityservice.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));
		}

	}

	@RequestMapping("mstPriorityExcelExport")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "select a.priority_id ,a.priority_name,a.description,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) AS IsActive from mst_priority a";
		String headerNames = "Priority Id,Priority Name,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=priority.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Priority List")));

	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("listByIsActive")
	public Iterable<MstPriority> listByIsActive(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "priorityId") String col) {

		return mstpriorityservice.findAllRecordsByIsActive(new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
				Sort.Direction.fromString(sort), col));

	}

}
