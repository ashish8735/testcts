package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Repository.MstResourceTypeRepository;
import com.CTS.Project.Services.MstResourceTypeService;

@Service
public class MstResourceTypeServiceImpl implements MstResourceTypeService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstResourceTypeRepository resourceTypeRepo;


	@Override
	public Page<MstResourceType> findAllRecords(PageRequest pageRequest) {
		return resourceTypeRepo.findAll(pageRequest);
	}

	@Override
	public Page<MstResourceType> completeSearch(String searchString, Pageable pageRequest) {
		
		return resourceTypeRepo.findAllByResourceTypeNameContainsAndIsActiveTrue(searchString ,pageRequest);

	}

}
