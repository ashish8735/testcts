package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Services.DashboardService;

@RestController
@RequestMapping("/dashbord")
public class DashbordController {

	@Autowired
	DashboardService dashboardService;
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	ExcelGenerator excelGenerator;

	@GetMapping
	@RequestMapping("getIncidentListByStages")
	public List<TranAddIncidentReview> getIncidentListByStages(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		
		if(adminCheck==1) {
			if (searchString == null || searchString.equals("")) {
				return dashboardService.getAllIncidentRecordForAdmin(resourceId, page, size, sort, col);
			} else {
				return dashboardService.getAllIncidentRecordForAdminSearch(resourceId,searchString, page, size, sort, col);
			}
		}else {
			if (searchString == null || searchString.equals("")) {
				return dashboardService.getAllIncidentRecordByStage(resourceId, page, size, sort, col);
			} else {
				return dashboardService.getAllIncidentRecordByStageSearch(resourceId,searchString, page, size, sort, col);
			}
		}
	}
	
	@RequestMapping("filterRecords")
	public List<TranAddIncidentReview> getFiterRecords(@RequestBody String seatchJoson) throws JSONException, ParseException {
		JSONObject json = new JSONObject(seatchJoson);
		return dashboardService.searchDashboardAdminFiter(json);
 
	}

	
	@GetMapping
	@RequestMapping("getCountsByStages/{resourceId}")
	public  Map<String, String> getCountsByStages(@PathVariable long resourceId){
		 respMap.put("inprogress", dashboardService.getAllInProgressCountsByStage(resourceId));
		 respMap.put("moreinforequired", dashboardService.getAllMoreInfoRequiredCountsByStage(resourceId));
		 respMap.put("resolved", dashboardService.getAllResolvedCountsByStage(resourceId));
		 respMap.put("forward", dashboardService.getAllForwardCountsByStage(resourceId));
		 respMap.put("open", dashboardService.getAllOpenCountsByStage(resourceId));
		 respMap.put("Reported", dashboardService.getAllReportedCountsByStage(resourceId));

		 return respMap;
	}
	
	@GetMapping
	@RequestMapping("getAdminCountsByStages")
	public   Map<String, String> getAdminCountsByStages(){
		respMap.put("inprogress", dashboardService.getAdminInProgressCountsByStage());
		respMap.put("moreinforequired", dashboardService.getAdminMoreInfoRequiredCountsByStage());
		respMap.put("resolved", dashboardService.getAdminResolvedCountsByStage());
		respMap.put("forward", dashboardService.getAdminForwardCountsByStage());
		respMap.put("open", dashboardService.getAdminOpenCountsByStage());
		 respMap.put("Reported", dashboardService.getAdminReportedCountsByStage());
		return respMap;
	}
	
	@GetMapping
	@RequestMapping("getAllUnResolvedListForAdmin")
	public List<TranAddIncidentReview> getAllUnResolvedListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		if(adminCheck==1) {
			return dashboardService.getAllUnResolvedListForAdmin(resourceId, page, size, sort, col);
		} else {
			return dashboardService.getAllUnResolvedListForUser(resourceId, page, size, sort, col);
		}
	}
	
	@RequestMapping("customeExport")
	public ResponseEntity<InputStreamResource> customeExport(@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) throws IOException {
		String query = "";
		if(adminCheck==1) {
			query+="select tai.incident_id,mstapplica4_.application_name,date(tranaddinc0_.created_date),TIME(tranaddinc0_.created_date), " + 
					"tai.subject,tai.mobile_no,p.resource_name,mstinciden2_.incident_state_name,it.incident_type_name,rp.resource_name as pending_at,tranaddinc0_.incident_pending_days " + 
					" from transaction_addincidentreview tranaddinc0_  " + 
					" inner join transaction_addincident tai on tranaddinc0_.auto_incident_id=tai.auto_incident_id  " + 
					" inner join mst_resource_pool p on tai.createuser=p.resource_id " + 
					" inner join mst_incedent_type it on tai.tai_incident_type_id=it.incident_type_id " + 
					" inner join  mst_resource_pool rp on tai.assigned_to=rp.resource_id " + 
					" cross join mst_stage mststage1_  cross join mst_incidentstate mstinciden2_ cross join transaction_addincident tranaddinc3_ " + 
					" cross join mst_application mstapplica4_ where tranaddinc0_.application_stage_id=mststage1_.s_id " + 
					" and tranaddinc0_.incident_state_id=mstinciden2_.incident_state_id and tranaddinc0_.auto_incident_id=tranaddinc3_.auto_incident_id  " + 
					" and tranaddinc3_.tia_application_id=mstapplica4_.application_id and tranaddinc0_.is_active=1 " + 
					" and mststage1_.is_active=1 and mstinciden2_.is_active=1 and mstapplica4_.is_active=1";
		}else {
			query += "select tai.incident_id,a.application_name,date(tair.created_date),TIME(tair.created_date),tai.subject,tai.mobile_no,p.resource_name, " + 
					"isi.incident_state_name,it.incident_type_name,temp.resource_name as pending_at,tair.incident_pending_days from transaction_addincidentreview tair "+ 
					"  inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id " + 
					" inner join mst_stage s on tair.application_stage_id=s.s_id " + 
					" inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id " + 
					" inner join mst_application a on tai.tia_application_id=a.application_id " + 
					" inner join mst_resource_pool p on tai.createuser=p.resource_id " + 
					" inner join  mst_resource_pool temp on tai.assigned_to=temp.resource_id " + 
					" inner join mst_incedent_type it on tai.tai_incident_type_id=it.incident_type_id " + 
					"  where tair.application_stage_id in " + 
					"  (select rs.stage_id from mapping_rolestage rs inner join mst_stage sp on rs.stage_id=sp.s_id where sp.is_active=1 " + 
					"	and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id " + 
					"	 where rr.mst_resource_id="+resourceId+" and r.is_active=1 and rr.is_active=1 )) and tair.is_active=1";
		}

		String headerNames = "Incident Id,Application Name,Created Date,Time,Subject,Mobile No.,Posted By,Status,Incident type,Pending at,Aging days";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=DashboardList.xlsx");
		return ResponseEntity.ok().headers(headers)
				.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "DashboardList")));

	}
	
	@GetMapping
	@RequestMapping("getAllResolvedListForAdmin")
	public List<TranAddIncidentReview> getAllResolvedListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		if(adminCheck==1) {
			return dashboardService.getAllResolvedListForAdmin(resourceId, page, size, sort, col);
		} else {
			return dashboardService.getAllResolvedListForUser(resourceId, page, size, sort, col);
		}
	}
	
	@GetMapping
	@RequestMapping("getAllOpenListForAdmin")
	public List<TranAddIncidentReview> getAllOpenListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "resourceId", required = false) long resourceId,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentReviewId") String col,
			@RequestParam(value = "adminCheck", required = false, defaultValue = "0") int adminCheck) {
		if(adminCheck==1) {
			return dashboardService.getAllOpenListForAdmin(resourceId, page, size, sort, col);
		} else {
			return dashboardService.getAllOpenListForUser(resourceId, page, size, sort, col);
		}
	}
	
}
