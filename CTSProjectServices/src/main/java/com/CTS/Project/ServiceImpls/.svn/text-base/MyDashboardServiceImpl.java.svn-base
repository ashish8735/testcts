package com.CTS.Project.ServiceImpls;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Services.MyDashboardService;

@Service
public class MyDashboardServiceImpl implements MyDashboardService
{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> getAllIncidentRecordByStage(String resourceId, String page, String size,
			String sort, String col)
	
	{

       String query="select * from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1"; 
	
       List<TranAddIncidentReview> list=entityManager.createNativeQuery(query,TranAddIncidentReview.class).setFirstResult((Integer.parseInt(page)-1)*Integer.parseInt(size)).setMaxResults(Integer.parseInt(size)).getResultList();
		
       String counQuery=StringUtils.replace(query, " * fr", " count(tair.incident_review_id) fr");
       BigInteger count=(BigInteger) entityManager.createNativeQuery(counQuery).getSingleResult();
      
      String q="SELECT COUNT(incident_review_id) FROM transaction_addincidentreview a ,transaction_addincident b WHERE b.created_by="+resourceId+" AND a.is_active=1";
       BigInteger resolvecount=(BigInteger) entityManager.createNativeQuery(q).getSingleResult();
       
       if(list.size()>0) {
    	   list.get(0).setCount(count.longValue());
    	   list.get(0).setResolvedCount(resolvecount.longValue());
       }
       
		return  list;
	}

	@Override
	public List<TranAddIncidentReview> getAllResolvedListForUser(long resourceId, String page, String size, String sort,
			String col) {
//		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
//				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
//				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
//				+ "and tair.is_active=1 and tair.incident_state_id=4";

	       String query="select * from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.incident_state_id=6"; 

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ " and tair.is_active=1 and tair.incident_state_id=6";
//		 limit "+((Integer.parseInt(page)-1)*Integer.parseInt(size))+","+size
		@SuppressWarnings("unchecked")
		List<TranAddIncidentReview> list = entityManager.createNativeQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count.longValue());
		}

		return list;
	}
	
	@Override
	public List<TranAddIncidentReview> getAllOpenedListForUser(long resourceId, String page, String size, String sort,
			String col) {
		   String query="select * from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.incident_state_id=2 and tair.is_active=1 "; 

			String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
					+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
					+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
					+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
					+ " and tair.is_active=1 and tair.incident_state_id=2";
//			 limit "+((Integer.parseInt(page)-1)*Integer.parseInt(size))+","+size
			@SuppressWarnings("unchecked")
			List<TranAddIncidentReview> list = entityManager.createNativeQuery(query, TranAddIncidentReview.class)
					.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
					.setMaxResults(Integer.parseInt(size)).getResultList();
			BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
			if (list.size() > 0) {
				list.get(0).setCount(count.longValue());
			}

			return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> getAllUnResolvedListForUser(long resourceId, String page, String size,
			String sort, String col) {
//		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
//				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
//				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
//				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
//				+ "and tair.is_active=1 and tair.incident_state_id=2";

	       String query="select * from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1) and ta.created_by="+resourceId+" and tair.incident_state_id=4 and tair.is_active=1"; 

//		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
//				+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
//				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
//				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
//				+ " and tair.is_active=1 and tair.incident_state_id=2";
//		 limit "+((Integer.parseInt(page)-1)*Integer.parseInt(size))+","+size
	       String countQuery="select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1) and ta.created_by="+resourceId+" and tair.incident_state_id=4 and tair.is_active=1"; 

		List<TranAddIncidentReview> list = entityManager.createNativeQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count.longValue());
		}

		return list;
	}
	
	@Override
	public String getAllInProgressCountsByStage(long resourceId) {
		System.out.println("resource=1=" + resourceId);
		BigInteger inprogress = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1 and tair.incident_state_id=4")
				.getSingleResult();
		return inprogress.toString();
	}

	@Override
	public String getAllMoreInfoRequiredCountsByStage(long resourceId) {
		System.out.println("resource=2=" + resourceId);
		BigInteger moreinfo = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1 and tair.incident_state_id=5")
				.getSingleResult();
		return moreinfo.toString();
	}

	@Override
	public String getAllResolvedCountsByStage(long resourceId) {
		System.out.println("resource=3=" + resourceId);
		BigInteger resolved = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+"  and tair.incident_state_id=6")
				.getSingleResult();
		return resolved.toString();
	}
	
	@Override
	public String getAllReportedCountsByStage(long resourceId) {
		BigInteger reported = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1 and tair.incident_state_id=1")
				.getSingleResult();
		return reported.toString();
	}
	@Override
	public String getAllOpenCountsByStage(long resourceId) {
		BigInteger opened = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1 and tair.incident_state_id=2")
				.getSingleResult();
		return opened.toString();
	}
	@Override
	public String getAllForwardCountsByStage(long resourceId) {
		BigInteger forward = (BigInteger) entityManager.createNativeQuery("select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1 and tair.incident_state_id=3")
				.getSingleResult();
		return forward.toString();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> searchDashboardUserFiter(JSONObject json) throws JSONException, ParseException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = (!json.get("fromDate").toString().equals(""))
				? formater.format(formater.parse((String) json.get("fromDate")))
				: "";
		String toDate = (!json.get("toDate").toString().equals(""))
				? formater.format(formater.parse((String) json.get("toDate")))
				: "";
		if (fromDate.equals("")) {
			fromDate = "1990-05-03";
		}

		if (toDate.equals("")) {
			toDate = formater.format(new Date());
		}

		String query = " select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id  inner join mst_application a on tai.tia_application_id=a.application_id "
					+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
					+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id "
					+ "  where rr.mst_resource_id=" + json.getLong("resourceId")
					+ " and r.is_active=1 and rr.is_active=1)) and tair.is_active=1 and a.is_active=1 and (date(tair.created_date) between '"
					+ fromDate + "' and '" + toDate + "') and tai.created_by="+json.getLong("resourceId")+"";
		

		if (json.getInt("incidentTypeId") != 0) {
			query += " and tai.tai_incident_type_id=" + json.getInt("incidentTypeId");
		}

		if (json.getInt("incidentStatusId") != 0) {
			query += " and tair.incident_state_id=" + json.getInt("incidentStatusId");
		}

		if (json.getInt("agingDays") != 0) {
			if (json.getInt("agingDays") == 4) {
				query += " and tair.incident_pending_days>" + (json.getInt("agingDays") - 1);
			} else {
				query += " and tair.incident_pending_days=" + json.getInt("agingDays");
			}

		}

		String countQuery = StringUtils.replace(query, " * fr", " count(tair.incident_review_id) fr");

		List<TranAddIncidentReview> list = entityManager.createNativeQuery(query, TranAddIncidentReview.class)
				.setFirstResult(((json.getInt("page") - 1) * json.getInt("size"))).setMaxResults(json.getInt("size"))
				.getResultList();
		BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count.longValue());
		}

		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> getAllIncidentRecordForStageSearch(String resourceId, String searchString,
			String page, String size, String sort, String col) {

	       String query="select * from transaction_addincidentreview tair inner join transaction_addincident ta on tair.auto_incident_id=ta.auto_incident_id where ta.created_by="+resourceId+" and tair.is_active=1"
	       		+ " and (ta.incident_id like '%"+searchString+"%' or ta.subject like '%"+searchString+"%' or ta.mobile_no like '%"+searchString+"%')"; 
		
	       List<TranAddIncidentReview> list=entityManager.createNativeQuery(query,TranAddIncidentReview.class).setFirstResult((Integer.parseInt(page)-1)*Integer.parseInt(size)).setMaxResults(Integer.parseInt(size)).getResultList();
			
	       String counQuery=StringUtils.replace(query, " * fr", " count(tair.incident_review_id) fr");
	       BigInteger count=(BigInteger) entityManager.createNativeQuery(counQuery).getSingleResult();
	      
	       if(list.size()>0) {
	    	   list.get(0).setCount(count.longValue());
	       }
	       
			return  list;
	}
	

	

	

	
	

}
