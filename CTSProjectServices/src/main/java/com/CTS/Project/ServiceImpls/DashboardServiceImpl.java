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
import com.CTS.Project.Services.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> getAllIncidentRecordByStage(long resourceId, String page, String size,
			String sort, String col) {
		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId
				+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1";

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId
				+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ " and tair.is_active=1";
//		 limit "+((Integer.parseInt(page)-1)*Integer.parseInt(size))+","+size
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
	public List<TranAddIncidentReview> getAllIncidentRecordForAdmin(long resourceId, String page, String size,
			String sort, String col) {
		String query = "select tair from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1";

		String countQuery = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1";

		List<TranAddIncidentReview> list = entityManager.createQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		Long count = (Long) entityManager.createQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count);
		}

		return list;
	}

	@Override
	public List<TranAddIncidentReview> getAllIncidentRecordForAdminSearch(long resourceId, String searchString,
			String page, String size, String sort, String col) {

		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " inner join mst_stage s on tair.application_stage_id=s.s_id "
				+ " inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id "
				+ " inner join mst_application a on tai.tia_application_id=a.application_id "
				+ " inner join mst_resource_pool p on tai.createuser=p.resource_id "
				+ " inner join  mst_resource_pool rp on tai.assigned_to=rp.resource_id "
				+ " where tair.is_active=1 and s.is_active=1 and isi.is_active=1 and a.is_active=1 "
				+ " and (tai.incident_id like '%" + searchString + "%' or a.application_name like '%" + searchString
				+ "%'" + " or tai.subject like '%" + searchString + "%' or tai.mobile_no like '%" + searchString + "%'"
				+ " or p.resource_name like '%" + searchString + "%' or rp.resource_name like '%" + searchString
				+ "%')";

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " inner join mst_stage s on tair.application_stage_id=s.s_id "
				+ " inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id "
				+ " inner join mst_application a on tai.tia_application_id=a.application_id "
				+ " inner join mst_resource_pool p on tai.createuser=p.resource_id "
				+ " inner join  mst_resource_pool rp on tai.assigned_to=rp.resource_id "
				+ " where tair.is_active=1 and s.is_active=1 and isi.is_active=1 and a.is_active=1 "
				+ " and (tai.incident_id like '%" + searchString + "%' or a.application_name like '%" + searchString
				+ "%'" + " or tai.subject like '%" + searchString + "%' or tai.mobile_no like '%" + searchString + "%'"
				+ " or p.resource_name like '%" + searchString + "%' or rp.resource_name like '%" + searchString
				+ "%')";

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
	public List<TranAddIncidentReview> getAllIncidentRecordByStageSearch(long resourceId, String searchString,
			String page, String size, String sort, String col) {
		String query = "select * from transaction_addincidentreview tair "
				+ " inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "inner join mst_stage s on tair.application_stage_id=s.s_id inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id "
				+ "inner join mst_application a on tai.tia_application_id=a.application_id inner join mst_resource_pool p on tai.createuser=p.resource_id "
				+ " inner join  mst_resource_pool rp on tai.assigned_to=rp.resource_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId
				+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1" + "  and (tai.incident_id like '%" + searchString
				+ "%' or a.application_name like '%" + searchString + "%' or tai.subject like '%" + searchString + "%' "
				+ "	or tai.mobile_no like '%" + searchString + "%' or p.resource_name like '%" + searchString
				+ "%' or rp.resource_name like '%" + searchString + "%')";

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair"
				+ " inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "inner join mst_stage s on tair.application_stage_id=s.s_id inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id "
				+ "inner join mst_application a on tai.tia_application_id=a.application_id inner join mst_resource_pool p on tai.createuser=p.resource_id "
				+ "inner join mst_incidentstate ms on tair.incident_state_id=ms.incident_state_id inner join  mst_resource_pool rp on tai.assigned_to=rp.resource_id "
				+ "inner join mst_incedent_type it on tai.tai_incident_type_id=it.incident_type_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId
				+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1" + "  and (tai.incident_id like '%" + searchString
				+ "%' or a.application_name like '%" + searchString + "%' or tair.created_date like '%" + searchString
				+ "%' or tai.subject like '%" + searchString + "%' " + "	or tai.mobile_no like '%" + searchString
				+ "%' or p.resource_name like '%" + searchString + "%' or ms.incident_state_name like '%" + searchString
				+ "%' or it.incident_type_name like '%" + searchString + "%' " + "		 or rp.resource_name like '%"
				+ searchString + "%')";

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
	public List<TranAddIncidentReview> searchDashboardAdminFiter(JSONObject json) throws JSONException, ParseException {
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

		String query = "";
		if (json.getInt("adminCheck") == 1) {
			query += "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
					+ "inner join mst_stage s on tair.application_stage_id=s.s_id inner join mst_incidentstate isi on tair.incident_state_id=isi.incident_state_id "
					+ "inner join mst_application a on tai.tia_application_id=a.application_id where tair.is_active=1 and s.is_active=1 and isi.is_active=1 and a.is_active=1 "
					+ "  and  (date(tair.created_date) between '" + fromDate + "' and '" + toDate + "') ";
		} else {
			query += " select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id  inner join mst_application a on tai.tia_application_id=a.application_id "
					+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
					+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id "
					+ "  where rr.mst_resource_id=" + json.getLong("resourceId")
					+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) and tair.is_active=1 and a.is_active=1 and (date(tair.created_date) between '"
					+ fromDate + "' and '" + toDate + "') ";
		}

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

	@Override
	public String getAllInProgressCountsByStage(long resourceId) {
		System.out.println("resource=1=" + resourceId);
		BigInteger inprocess = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=4 and tair.is_active=1")
				.getSingleResult();
		return inprocess.toString();
	}

	@Override
	public String getAllMoreInfoRequiredCountsByStage(long resourceId) {
		System.out.println("resource=2=" + resourceId);
		BigInteger moreinforequired = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=5 and tair.is_active=1")
				.getSingleResult();
		return moreinforequired.toString();
	}

	@Override
	public String getAllResolvedCountsByStage(long resourceId) {
		System.out.println("resource=3=" + resourceId);
		BigInteger resolved = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=6 and tair.is_active=1")
				.getSingleResult();
		return resolved.toString();
	}

	@Override
	public String getAllForwardCountsByStage(long resourceId) {
		System.out.println("resource=4=" + resourceId);
		BigInteger forward = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1  and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=3 and tair.is_active=1")
				.getSingleResult();
		return forward.toString();
	}
	@Override
	public String getAllOpenCountsByStage(long resourceId) {
		BigInteger open = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1  and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=2 and tair.is_active=1")
				.getSingleResult();
		return open.toString();
	}

	@Override
	public String getAllReportedCountsByStage(long resourceId) {
		BigInteger reported = (BigInteger) entityManager.createNativeQuery(
				"select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
						+ " where tair.application_stage_id"
						+ " in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1"
						+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
						+ resourceId
						+ " and r.is_active=1 and rr.is_active=1  and rr.mst_application_id=tai.tia_application_id))"
						+ "and tair.incident_state_id=1 and tair.is_active=1")
				.getSingleResult();
		return reported.toString();
	}
	@Override
	public String getAdminInProgressCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=4";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}

	@Override
	public String getAdminMoreInfoRequiredCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=5";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}

	@Override
	public String getAdminResolvedCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=6";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}

	@Override
	public String getAdminForwardCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=3";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}
	@Override
	public String getAdminOpenCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=2";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}
	@Override
	public String getAdminReportedCountsByStage() {
		String adminCount = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1"
				+ "and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=1";
		Long count = (Long) entityManager.createQuery(adminCount).getSingleResult();
		return count.toString();
	}
	@Override
	public List<TranAddIncidentReview> getAllUnResolvedListForAdmin(long resourceId, String page, String size,
			String sort, String col) {
		String query = "select tair from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=4";

		String countQuery = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=4";

		List<TranAddIncidentReview> list = entityManager.createQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		Long count = (Long) entityManager.createQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count);
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TranAddIncidentReview> getAllUnResolvedListForUser(long resourceId, String page, String size,
			String sort, String col) {
		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1 and tair.incident_state_id=4";

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ " and tair.is_active=1 and tair.incident_state_id=4";
//		 limit "+((Integer.parseInt(page)-1)*Integer.parseInt(size))+","+size
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
	public List<TranAddIncidentReview> getAllResolvedListForAdmin(long resourceId, String page, String size,
			String sort, String col) {
		String query = "select tair from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=6";

		String countQuery = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=6";

		List<TranAddIncidentReview> list = entityManager.createQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		Long count = (Long) entityManager.createQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count);
		}

		return list;
	}

	@Override
	public List<TranAddIncidentReview> getAllResolvedListForUser(long resourceId, String page, String size, String sort,
			String col) {
		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1 and tair.incident_state_id=6";

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
	public List<TranAddIncidentReview> getAllOpenListForAdmin(long resourceId, String page, String size, String sort,
			String col) {
		String query = "select tair from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=2";

		String countQuery = "select count(tair.incidentReviewId) from TranAddIncidentReview tair where tair.isActive=1 and tair.applicationStageId.isActive=1 and tair.incidentStateId.isActive=1 and tair.autoIncidentId.taiApplicationId.isActive=1 and tair.incidentStateId.incidentStateId=2";

		List<TranAddIncidentReview> list = entityManager.createQuery(query, TranAddIncidentReview.class)
				.setFirstResult((Integer.parseInt(page) - 1) * Integer.parseInt(size))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		Long count = (Long) entityManager.createQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count);
		}

		return list;
	}

	@Override
	public List<TranAddIncidentReview> getAllOpenListForUser(long resourceId, String page, String size, String sort,
			String col) {
		String query = "select * from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ " where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ "and tair.is_active=1 and tair.incident_state_id=2";

		String countQuery = "select count(tair.incident_review_id) from transaction_addincidentreview tair inner join transaction_addincident tai on tair.auto_incident_id=tai.auto_incident_id "
				+ "where tair.application_stage_id in (select rs.stage_id from mapping_rolestage rs inner join mst_stage s on rs.stage_id=s.s_id where s.is_active=1 "
				+ " and rs.role_id in (select rr.mst_role_id from mapping_resourcerole rr inner join mst_role r on rr.mst_role_id=r.role_id where rr.mst_resource_id="
				+ resourceId + " and r.is_active=1 and rr.is_active=1 and rr.mst_application_id=tai.tia_application_id)) "
				+ " and tair.is_active=1 and tair.incident_state_id=2";
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



	

}
