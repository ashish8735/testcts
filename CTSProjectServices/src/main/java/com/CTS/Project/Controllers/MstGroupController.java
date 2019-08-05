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
import com.CTS.Project.Models.MstGroup;
import com.CTS.Project.Services.MstGroupService;

@RestController
@RequestMapping("/mstGroup")
public class MstGroupController {
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstGroupService mstGroupService;
	
	@Autowired
	ExcelGenerator excelGenerator;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstGroup> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "groupId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstGroupService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstGroupService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstGroup mstgroup) {
		if (mstgroup.getGroupName() != null) {
			mstGroupService.save(mstgroup);
			respMap.put("success", "1");
			respMap.put("msg", "Added Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}

	@RequestMapping("byid/{groupId}")
	public MstGroup read(@PathVariable("groupId") Long groupId) {
		MstGroup mstgrouplist = mstGroupService.findOneById(groupId);
		return mstgrouplist;
	}

	@PutMapping("delete/{groupId}")
	public Map<String, String> delete(@PathVariable("groupId") Long groupId) {
		if (groupId != 0) {
			mstGroupService.deleteById(groupId);
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
		
		String query = "select gr.group_id,gr.group_name,gr.description,(case when (CAST(gr.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_group gr";
		String headerNames = "Group Id,Group Name,Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=group.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Group")));

	}

}
