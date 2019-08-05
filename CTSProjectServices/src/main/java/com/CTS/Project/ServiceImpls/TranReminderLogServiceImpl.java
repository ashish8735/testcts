package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Models.TranReminderLog;
import com.CTS.Project.Repository.TranAddIncidentReviewrepository;
import com.CTS.Project.Repository.TranReminderLogRepository;
import com.CTS.Project.Services.TranReminderLogService;

@Service
public class TranReminderLogServiceImpl implements TranReminderLogService {

	@Autowired
	TranReminderLogRepository tranReminderLogRepository ;
	
	@Autowired
	TranAddIncidentReviewrepository tranAddIncidentReviewrepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public TranAddIncidentReview getIncidentReviewObject(Long reviewId) {
		return entityManager.find(TranAddIncidentReview.class, reviewId);
	}

	@Override
	public TranReminderLog saveData(TranReminderLog tranReminderLog) {
		return tranReminderLogRepository.save(tranReminderLog);
	}

	@Override
	public List<TranReminderLog> getReminderDetailsList(Long incidentReviewId) {
		System.out.println("incidentID=Service=" + incidentReviewId);
		return tranReminderLogRepository.findAllByIncidentReviewIdIncidentReviewIdAndIsActiveTrue(incidentReviewId);
		
	}

	
}
