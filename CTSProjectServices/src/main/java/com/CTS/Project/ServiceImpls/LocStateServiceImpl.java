package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.LocState;
import com.CTS.Project.Repository.LocStateRepository;
import com.CTS.Project.Services.LocStateService;

@Service
public class LocStateServiceImpl implements LocStateService{
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	LocStateRepository locStateRepo;


	@Override
	public void save(LocState ls) {
		locStateRepo.save(ls);
		
	}

	@Override
	public Page<LocState> findAllRecords(PageRequest pageRequest) {
		return locStateRepo.findAll(pageRequest);
	}

	
	  @Override public Page<LocState> completeSearch(String searchString, Pageable
	  pageRequest) {
	  
	  return locStateRepo.findAllByMstresourceZoneIdResourceZoneNameContainsOrStateNameContainsAndIsActiveTrue(
	  searchString,searchString, pageRequest);
	  
	  }

	@Override
	public void deleteById(Long stateId) {
		locStateRepo.deleteById(stateId);
	}
	 

}
