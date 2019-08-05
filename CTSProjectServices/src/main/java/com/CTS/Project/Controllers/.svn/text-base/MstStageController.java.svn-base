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
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Services.MstStageService;



@RestController
@RequestMapping("/mstStage")
public class MstStageController {
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstStageService mstStageService;

	@Autowired
	ExcelGenerator excelGenerator;
	
	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstStage mstStage) {
		if (mstStage.getStageName() != null) {
			mstStageService.save(mstStage);
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
	 
	  @RequestMapping("list") public Iterable<MstStage> list(
	 
	 @RequestParam(value = "page", required = false, defaultValue = "1") String
	 page,
	 
	  @RequestParam(value = "size", required = false, defaultValue = "100") String
	  size,
	
	  @RequestParam(value = "searchString", required = false) String searchString,
	  
	  @RequestParam(value = "sort", required = false, defaultValue = "DESC") String
	  sort,
	  
	 @RequestParam(value = "col", required = false, defaultValue = "sId") String
	 col) {
	  
	  if (searchString == null || searchString.equals("")) { return
	 mstStageService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
	  Integer.parseInt(size), Sort.Direction.fromString(sort), col));
	 
	  } else {
	  
	  return mstStageService.completeSearch(searchString, new
	  PageRequest(Integer.parseInt(page) - 1, Integer.parseInt(size),
	 Sort.Direction.fromString(sort), col));
	 
	 }
	 
	 }
	 
	@RequestMapping("byid/{sId}")
	public MstStage read(@PathVariable("sId") Long sId) {
		MstStage objMstStage = mstStageService.findOneById(sId);
		return objMstStage;
	}

	@PutMapping("delete/{sId}")
	public Map<String, String> delete(@PathVariable("sId") Long sId) {
		if (sId != 0) {
			mstStageService.deleteById(sId);
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

		String query = "select a.s_id,a.stage_name,a.description,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_stage a";
		String headerNames = "Stage Id,Stage Name, Description,Is Active";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=Stage.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Stage")));

	}


}


