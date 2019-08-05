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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Models.RoleStageMap;
import com.CTS.Project.Services.RoleStageMapService;

@RestController
@RequestMapping("roleStageMap")
public class RoleStageMapController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	RoleStageMapService rolemapservice;

	@Autowired
	ExcelGenerator excelGenerator;

	@PostMapping("/add")
	public Map<String, String> addpriority(@RequestBody RoleStageMap rolestage) {
		RoleStageMap obj = rolemapservice.checkexist(rolestage.getMaproleId().getRoleId(),
				rolestage.getStageId().getsId());
		if (obj == null) {
			if (rolestage.getStageId().getsId() != 0 && rolestage.getMaproleId().getRoleId() != 0) {
				rolemapservice.save(rolestage);
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

	@PutMapping("delete/{roleStageId}")
	public Map<String, String> deleteById(@PathVariable Long roleStageId) {
		System.out.println("holidayId--------------------" + roleStageId);
		if (roleStageId != 0) {
			rolemapservice.deleteById(roleStageId);
			respMap.put("success", "1");
			respMap.put("msg", "Removed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Delete Null Field");
			return respMap;
		}
	}

	@GetMapping("editrolestagemap/{roleStageId}")
	public RoleStageMap editById(@PathVariable Long roleStageId) {
		System.out.println("in get id-------------------");
		return rolemapservice.findById(roleStageId);

	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<RoleStageMap> list(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "roleStageId") String col) {

		if (searchString == null || searchString.equals("")) {
			System.out.println();
			return rolemapservice.findAllRecords(new PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
					Sort.Direction.fromString(sort), col));

		} else {
			System.out.println();
			return rolemapservice.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));
		}

	}

	@GetMapping("maprolelist")
	public List<MstRole> getListOfMstapplication() {
		System.out.println("in role---------------------------------");
		List<MstRole> mstroleist = rolemapservice.getAllMstRole();

		return mstroleist;
	}

	@GetMapping("stagelist")
	public List<MstStage> getListOfMstStage() {
		List<MstStage> stagelist = rolemapservice.getAllmstStage();

		return stagelist;
	}

	@RequestMapping("roleStagemaapExls")
	public ResponseEntity<InputStreamResource> customeExport() throws IOException {

		String query = "SELECT a.role_stage_id,role.role_name,stage.stage_name,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) AS IsActive from mapping_rolestage a JOIN mst_role role ON a.role_id=role.role_id JOIN mst_stage stage ON a.stage_id=stage.s_id";
		String headerNames = "Id,Role Name,Stage Name,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=rolestage_map.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(
				excelGenerator.createCustoneExcel(headerNames, query, "Map Application Stage")));

	}
}
