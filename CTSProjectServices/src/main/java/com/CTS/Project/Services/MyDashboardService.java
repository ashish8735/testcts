package com.CTS.Project.Services;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.CTS.Project.Models.TranAddIncidentReview;


public interface MyDashboardService 

{

	

	List<TranAddIncidentReview> getAllIncidentRecordByStage(String resourceId, String page, String size, String sort,String col);
			
	List<TranAddIncidentReview> getAllResolvedListForUser(long resourceId, String page, String size, String sort,String col);
	List<TranAddIncidentReview> getAllUnResolvedListForUser(long resourceId, String page, String size, String sort,String col);
	String getAllInProgressCountsByStage(long resourceId);
	List<TranAddIncidentReview> searchDashboardUserFiter(JSONObject json) throws JSONException, ParseException;

	 String getAllMoreInfoRequiredCountsByStage(long resourceId);
	 
	 String getAllResolvedCountsByStage(long resourceId);
	 
	 String getAllForwardCountsByStage(long resourceId);

	List<TranAddIncidentReview> getAllIncidentRecordForStageSearch(String resourceId, String searchString, String page,
			String size, String sort, String col);

	String getAllOpenCountsByStage(long resourceId);

	String getAllReportedCountsByStage(long resourceId);

	List<TranAddIncidentReview> getAllOpenedListForUser(long resourceId, String page, String size, String sort,
			String col);

	
}
