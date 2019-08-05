package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstIncidentState;
import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Repository.MstIncidentStateRepository;
import com.CTS.Project.Services.MstIncidentStateService;

@Service
public class MstIncidentStateServiceImpl implements MstIncidentStateService{

	@Autowired
	MstIncidentStateRepository mstIncidentStateRepository;
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Page<MstIncidentState> findAllRecordsIsActive(Pageable pageRequest) {
		return mstIncidentStateRepository.findAllByIsActiveTrue(pageRequest);
	}

	@Override
	public TranAddIncidentReview updateState(long incident_id,long currentUser) {
		   
		String UpdateQuery="UPDATE transaction_addincidentreview b ,transaction_addincident a SET a.incident_stateid=2,a.tai_incident_state_id=2 , b.incident_state_id=2,b.review_by="+currentUser+",b.review_date=NOW() WHERE b.auto_incident_id="+incident_id+" AND a.auto_incident_id="+incident_id+" AND b.is_active=1";
		entityManager.createNativeQuery(UpdateQuery).executeUpdate();
	TranAddIncidentReview list=(TranAddIncidentReview) entityManager.createNativeQuery("select *from transaction_addincidentreview where auto_incident_id="+incident_id+" and is_active=1 ",TranAddIncidentReview.class).getSingleResult();
		return list ;
	}

}
