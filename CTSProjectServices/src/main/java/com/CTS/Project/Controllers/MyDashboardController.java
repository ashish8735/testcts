package com.CTS.Project.Controllers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Services.MyDashboardService;

@RestController
@RequestMapping("/mydashboardcontroller")
public class MyDashboardController 
{	
	@Autowired
	ExcelGenerator excelGenerator;
	
	@Autowired
	MyDashboardService mydashboardservice;
	Map<String, String> respMap = new HashMap<String, String>();

	
	@GetMapping
	@RequestMapping("getallIncidentListByStages")
	public List<TranAddIncidentReview> getIncidentListByStages(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) String resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col) {
		
		if (searchString == null || searchString.equals("")) {
			return mydashboardservice.getAllIncidentRecordByStage(resourceId, page, size, sort, col);
		} else {
			return mydashboardservice.getAllIncidentRecordForStageSearch(resourceId,searchString, page, size, sort, col);
		}

		
	}
	
	@GetMapping
	@RequestMapping("getAllResolvedListForUser")
	public List<TranAddIncidentReview> getAllResolvedListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		
			return mydashboardservice.getAllResolvedListForUser(resourceId, page, size, sort, col);
		
	}
	@GetMapping
	@RequestMapping("getAllUnResolvedListForUser")
	public List<TranAddIncidentReview> getAllUnResolvedListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		
			return mydashboardservice.getAllUnResolvedListForUser(resourceId, page, size, sort, col);
		
	}
	
	@GetMapping
	@RequestMapping("getAllOpenedListForUser")
	public List<TranAddIncidentReview> getAllOpenedListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		
			return mydashboardservice.getAllOpenedListForUser(resourceId, page, size, sort, col);
		
	}
	@GetMapping
	@RequestMapping("filterRecords")
	public List<TranAddIncidentReview> getFiterRecords(@RequestBody String seatchJoson) throws JSONException, ParseException {
		JSONObject json = new JSONObject(seatchJoson);
		return mydashboardservice.searchDashboardUserFiter(json);
 
	}
	@PostMapping
	@RequestMapping("getCountsByStages/{resourceId}")
	public  Map<String, String> getCountsByStages(@PathVariable long resourceId){
		 System.out.println("fffffffffffffffffffffffffffffffffffffff"+mydashboardservice.getAllInProgressCountsByStage(resourceId));
			
		respMap.put("inprogress", mydashboardservice.getAllInProgressCountsByStage(resourceId));
		 respMap.put("moreinforequired", mydashboardservice.getAllMoreInfoRequiredCountsByStage(resourceId));
		 respMap.put("resolved", mydashboardservice.getAllResolvedCountsByStage(resourceId));
		 respMap.put("forward", mydashboardservice.getAllForwardCountsByStage(resourceId));
		 respMap.put("open", mydashboardservice.getAllOpenCountsByStage(resourceId));
		 respMap.put("Reported", mydashboardservice.getAllReportedCountsByStage(resourceId));

		 return respMap;
	}

	}
	
	
