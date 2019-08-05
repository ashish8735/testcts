package com.CTS.Project.Controllers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Services.AgeingCountService;

@RestController
public class AgeingCountController {
	
	@Autowired
	AgeingCountService ageingService;
	
	@PersistenceContext
	EntityManager entityManager;	
	
	@Transactional
	@Scheduled(cron = "0 30 10 1/1 * ?")
	public List<Object> unresolvedIncidentReview() {
	
	List<Object> list=ageingService.getAgeingCount();

		return list;

	}
	
	
}
