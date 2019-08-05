package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.IncidentCategory;
import com.CTS.Project.Repository.IncidentCategoryRepository;
import com.CTS.Project.Services.IncidentCategoryService;

@Service
public class IncidentCategoryServiceImpl implements IncidentCategoryService
{

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	IncidentCategoryRepository incidentCategoryRepository;
	@Override
	public void save(IncidentCategory incidentCategory) {
		
		incidentCategoryRepository.save(incidentCategory);
		
	}

	@Override
	public Page<IncidentCategory> findAllRecords(PageRequest pageRequest) {
		
		return incidentCategoryRepository.findAll(pageRequest);	
		
	}

	@Override
	public IncidentCategory findOneById(Integer incidentcategoryId) {
		
		return entityManager.find(IncidentCategory.class, incidentcategoryId);
	}

	@Override
	public void deleteById(Integer incidentcategoryId) {
		
		incidentCategoryRepository.deleteById(incidentcategoryId);
		
	}

	@Override
	public Iterable<IncidentCategory> compliteSearch(String searchString, PageRequest pageRequest) {
		 return incidentCategoryRepository.findAllByIncidentcategoryNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(searchString,searchString,pageRequest);
		 
		 
		 
	}

	@Override
	public Page<IncidentCategory> findAllRecordsByIsActive(Pageable pageRequest) {
		return incidentCategoryRepository.findAllByIsActiveTrue(pageRequest);
	}

	
	
	
	
	

	
}

