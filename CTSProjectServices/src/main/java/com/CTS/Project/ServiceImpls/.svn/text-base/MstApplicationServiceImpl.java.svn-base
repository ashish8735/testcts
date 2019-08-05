package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Repository.MstApplicationRepository;
import com.CTS.Project.Services.MstApplicationService;

@Service
public class MstApplicationServiceImpl implements MstApplicationService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstApplicationRepository mstApplicationRepository;

	@Override
	public void save(MstApplication mstApplication) {
		mstApplicationRepository.save(mstApplication);
	}

	@Override
	public Page<MstApplication> findAllRecords(PageRequest pageRequest) {
		return mstApplicationRepository.findAll(pageRequest);
	}

	@Override
	public MstApplication findOneById(Long appId) {
		return entityManager.find(MstApplication.class, appId);
	}

	@Override
	public void deleteById(Long appId) {
		mstApplicationRepository.deleteById(appId);
	}

	@Override
	public Page<MstApplication> compliteSearch(String searchString,Pageable pageRequest) {
		return mstApplicationRepository.findAllByAbbreviationNameContainsAndIsActiveTrueOrApplicationNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(searchString,searchString,searchString,pageRequest);
	}

	@Override
	public Page<MstApplication> findAllRecordsByIsActive(Pageable pageRequest) {
		return mstApplicationRepository.findAllByIsActiveTrue(pageRequest);
	}

}
