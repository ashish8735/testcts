package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.ApplicationTiming;
import com.CTS.Project.Repository.ApplicationTimingRepository;
import com.CTS.Project.Services.ApplicationTimingService;

@Service
public class ApplicationTimingServiceImpl implements ApplicationTimingService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ApplicationTimingRepository applicationTimingRepository;

	@Override
	public void save(ApplicationTiming applicationTiming) {

		applicationTimingRepository.save(applicationTiming);

	}

	@Override
	public Page<ApplicationTiming> findAllRecords(Pageable pageRequest) {
		return applicationTimingRepository.findAll(pageRequest);
	}

	@Override
	public ApplicationTiming findOneById(Long applicationtimingId) {
		return entityManager.find(ApplicationTiming.class, applicationtimingId);
	}

	@Override
	public void deleteById(Long applicationTimingId) {
		applicationTimingRepository.deleteById(applicationTimingId);
	}

	@Override
	public Iterable<ApplicationTiming> compliteSearch(String searchString, Pageable pageRequest) {

		return applicationTimingRepository.findAllByMatApplicationIdApplicationNameContainsAndIsActiveTrue(searchString,
				pageRequest);
	}

}
