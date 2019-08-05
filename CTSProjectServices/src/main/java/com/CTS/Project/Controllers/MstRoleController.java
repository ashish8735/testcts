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
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Services.MstRoleService;

@RestController
@RequestMapping("/mstRole")
public class MstRoleController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstRoleService mstRoleService;
	
	@Autowired
	ExcelGenerator excelGenerator;
	
	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstRole mstRole) {
		if (mstRole.getRoleName() != null) {
			mstRoleService.save(mstRole);
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
	public Iterable<MstRole> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "roleId") String col) {

		if (searchString == null || searchString.equals("")) {
			return mstRoleService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return mstRoleService.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

	@RequestMapping("byid/{appId}")
	public MstRole read(@PathVariable("appId") Long appId) {
		MstRole objMstRole = mstRoleService.findOneById(appId);
		return objMstRole;
	}

	@PutMapping("delete/{appId}")
	public Map<String, String> delete(@PathVariable("appId") Long appId) {
		if (appId != 0) {
			mstRoleService.deleteById(appId);
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

		String query = "select r.role_id,r.role_name,g.group_name,r.description from mst_role r inner join mst_group g on r.role_groupid=group_id ";
		String headerNames = "Role Id,Role Name,Group Name,Description";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=Role.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Role")));

	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("listByIsActive")
	public Iterable<MstRole> listByIsActive(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "roleId") String col) {

		return mstRoleService.findAllRecordsByIsActive(new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size), Sort.Direction.fromString(sort), col));
	}
}
