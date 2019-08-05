package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.TranHistoryDetails;
import com.CTS.Project.Repository.TranHistoryDetailsRepository;
import com.CTS.Project.Repository.TranReminderLogRepository;
import com.CTS.Project.Services.TranHistoryDetailsService;

@Service
public class TranHistoryDetailsServiceImpl implements TranHistoryDetailsService {

	@Autowired
	TranReminderLogRepository tranReminderLogRepository ;
	
	@Autowired
	TranHistoryDetailsRepository tranHistoryDetailsRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TranHistoryDetails> getReminderDetailsList(Long incidentReviewId) {
		return tranHistoryDetailsRepository.findAllByHistoryIncidentReviewIdIncidentReviewIdAndIsActiveTrue(incidentReviewId);	
		
	}
	
	
}
