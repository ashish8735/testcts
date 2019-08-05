package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstResourceDesignation;
import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Repository.MstDesignationRepository;

import com.CTS.Project.Services.MstResourceDesignationService;

@Service
public class MstDesignationServiceImpl implements MstResourceDesignationService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstDesignationRepository resourceDesignationRepo;


	@Override
	public void save(MstResourceDesignation resourcedesignation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<MstResourceDesignation> findAllRecords(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MstResourceType findOneById(Long resourceDesignationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long resourceDesignationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<MstResourceDesignation> completeSearch(String searchString, Pageable pageRequest) {
		
		return resourceDesignationRepo.findAllByResourceDesignationNameContainsOrDescriptionContainsAndIsActiveTrue(searchString,searchString,pageRequest);

	}

}
