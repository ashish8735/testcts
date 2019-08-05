package com.CTS.Project.ServiceImpls;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.CTS.Project.Services.AgeingCountService;

@Repository
public class AgeingCountServiceImpl implements AgeingCountService {
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	@PersistenceContext
	EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAgeingCount() {
		Query q=entityManager.createNativeQuery("SELECT a.created_date,a.auto_incident_id,b.incident_review_id FROM transaction_addincident a ,transaction_addincidentreview b WHERE a.auto_incident_id=b.auto_incident_id AND is_active=:set");
		q.setParameter("set", 1);
		List<Object[]> list=q.getResultList();
		List<Object> countlist=new ArrayList<Object>();
		for(Object[] obj:list)
		{
			Date created_date= (Date) obj[0];
			String created = formatter.format(created_date);
			System.out.println("created_date=="+created);	
			BigInteger bigApp=(BigInteger) obj[1];
			int auto_incident_id=bigApp.intValue();
			System.out.println("auto_incident_id=="+auto_incident_id);
			BigInteger biginteger=(BigInteger) obj[2];
			int incident_review_id=biginteger.intValue();
			System.out.println("incident_review_id=="+incident_review_id);
			Date currentdate = new Date(System.currentTimeMillis()); 
			String current = formatter.format(currentdate);
			System.out.println("current_date=="+current);
			
    			BigInteger sat_sun=(BigInteger)entityManager.createNativeQuery(" SELECT COUNT(v.selected_date) AS weekendCount FROM " + 
    					"(SELECT ADDDATE('1970-01-01',t4*10000 + t3*1000 + t2*100 + t1*10 + t0) AS selected_date FROM " + 
    					" (SELECT 0 t0 UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) t0, " + 
    					" (SELECT 0 t1 UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) t1, " + 
    					" (SELECT 0 t2 UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) t2, " + 
    					" (SELECT 0 t3 UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) t3, " + 
    					" (SELECT 0 t4 UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) t4) v " + 
    					" WHERE v.selected_date BETWEEN '"+created+"' AND '"+current+"' AND WEEKDAY(v.selected_date) IN (5,6);").getSingleResult();
//			BigInteger sat_sun=(BigInteger) Sat_Sun_count.getSingleResult();
			int count_sat=sat_sun.intValue();
			System.out.println("Sat_sun=="+count_sat);

			Query h=entityManager.createNativeQuery("SELECT COUNT(holiday_id) FROM mst_holiday WHERE holiday_date BETWEEN '"+created+"' AND '"+current+"'");
			BigInteger bigint=(BigInteger) h.getSingleResult();
			int holiday=bigint.intValue();
			holiday=holiday+count_sat;
			System.out.println("holiday=="+holiday);
			long count=getDayCount(created_date,currentdate,holiday);
			if(count<0) {
				count=0;
			}
			System.out.println("Pending_days"+count);
			countlist.add(count);
			String UpdateQuery="UPDATE transaction_addincidentreview b SET b.incident_pending_days="+count+" where b.is_active=1 AND  b.auto_incident_id="+auto_incident_id+"";
			Query query=entityManager.createNativeQuery(UpdateQuery);
			query.executeUpdate();
			String updateIncident="UPDATE transaction_addincident a SET a.incident_panding_days="+count+" where a.auto_incident_id="+auto_incident_id+"";
			Query qw=entityManager.createNativeQuery(updateIncident);
			qw.executeUpdate();		}
		return countlist;
	}
	public static long getDayCount(Date start,Date Current,int holidays) {
		  long countdays = -1;
		  try {
		    countdays = Math.round((Current.getTime() - start.getTime()) / (double) 86400000)-holidays;
		  } catch (Exception e) {
		  }
		  return countdays;
		}
	
//	@Override
//	public List<TranAddIncidentReview> getAgeingCountByModel() {
//			String query="SELECT *FROM transaction_addincidentreview a inner join transaction_addincident b on a.auto_incident_id=b.auto_incident_id where a.is_active=1";
//	       List<TranAddIncidentReview> list=entityManager.createNativeQuery(query,TranAddIncidentReview.class).getResultList();
//		for(TranAddIncidentReview tir:list)
//		{
//System.out.println("cccccccc"+tir.toString());
//			
//		}
//	       
//	       return list;
//	}

}
