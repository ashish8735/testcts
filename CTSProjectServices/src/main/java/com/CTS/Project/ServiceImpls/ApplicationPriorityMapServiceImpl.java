package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.ApplicationPriorityMap;
import com.CTS.Project.Repository.ApplicationPriorityMapRepository;
import com.CTS.Project.Services.ApplicationPriorityMapService;

@Service
public class ApplicationPriorityMapServiceImpl implements ApplicationPriorityMapService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ApplicationPriorityMapRepository applicationPriorityMapRepository;

	@Override
	public void save(ApplicationPriorityMap applicationPriorityMap) {
		applicationPriorityMapRepository.save(applicationPriorityMap);

	}

	@Override
	public Page<ApplicationPriorityMap> findAllRecords(PageRequest pageRequest) {

		return applicationPriorityMapRepository.findAll(pageRequest);
	}

	@Override
	public ApplicationPriorityMap findOneById(Long applicationPriorityID) {
		return entityManager.find(ApplicationPriorityMap.class, applicationPriorityID);

	}

	@Override
	public void deleteById(Long applicationPriorityID) {
		applicationPriorityMapRepository.deleteById(applicationPriorityID);
	}

	@Override
	public Iterable<ApplicationPriorityMap> completeSearch(String searchString, Integer searchInt,
			Pageable pageRequest) {
		return applicationPriorityMapRepository
				.findAllByMapApplicationIdApplicationNameContainsOrMapPriorityIdPriorityNameContainsOrConfigureOrderAndIsActiveTrue(
						searchString, searchString, searchInt, pageRequest);

	}

	@Override
	public ApplicationPriorityMap checkExist(long appId, long priorityId) {
		try {
			return entityManager.createQuery(
					"SELECT app FROM ApplicationPriorityMap app WHERE app.mapApplicationId.appId=" + appId
							+ " AND app.mapPriorityId.priorityId=" + priorityId + " AND app.isActive=1",
					ApplicationPriorityMap.class).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

}
