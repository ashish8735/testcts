package com.CTS.Project.Services;

import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.CTS.Project.Models.TranAddIncidentReview;

public interface DashboardService {

	List<TranAddIncidentReview> getAllIncidentRecordByStage(long resourceId, String page, String size, String sort,String col);

	List<TranAddIncidentReview> getAllIncidentRecordForAdmin(long resourceId, String page, String size, String sort,String col);

	List<TranAddIncidentReview> getAllIncidentRecordForAdminSearch(long resourceId, String searchString, String page, String size, String sort, String col);

	List<TranAddIncidentReview> getAllIncidentRecordByStageSearch(long resourceId, String searchString, String page,String size, String sort, String col);

	List<TranAddIncidentReview> searchDashboardAdminFiter(JSONObject json) throws JSONException, ParseException;
	
	List<TranAddIncidentReview> getAllUnResolvedListForAdmin(long resourceId, String page, String size, String sort,String col);
	
	List<TranAddIncidentReview> getAllUnResolvedListForUser(long resourceId, String page, String size, String sort,String col);
	
	List<TranAddIncidentReview> getAllResolvedListForAdmin(long resourceId, String page, String size, String sort,String col);
	
	List<TranAddIncidentReview> getAllResolvedListForUser(long resourceId, String page, String size, String sort,String col);
	
	List<TranAddIncidentReview> getAllOpenListForAdmin(long resourceId, String page, String size, String sort,
			String col);

	List<TranAddIncidentReview> getAllOpenListForUser(long resourceId, String page, String size, String sort,
			String col);
	
	String getAllInProgressCountsByStage(long resourceId);
	 
	 String getAllMoreInfoRequiredCountsByStage(long resourceId);
	 
	 String getAllResolvedCountsByStage(long resourceId);
	 
	 String getAllForwardCountsByStage(long resourceId);
	 
		String getAllOpenCountsByStage(long resourceId);

	 String getAdminInProgressCountsByStage();
	 
	 String getAdminMoreInfoRequiredCountsByStage();
	 
	 String getAdminResolvedCountsByStage();
	 
	 String getAdminForwardCountsByStage();

	String getAdminOpenCountsByStage();

	String getAllReportedCountsByStage(long resourceId);

	String getAdminReportedCountsByStage();

	
}
