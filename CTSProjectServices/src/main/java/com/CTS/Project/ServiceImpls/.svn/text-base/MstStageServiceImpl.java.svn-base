package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Repository.MstStageRepository;
import com.CTS.Project.Services.MstStageService;

@Service
public class MstStageServiceImpl implements MstStageService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	MstStageRepository mstStageRepository;

	@Override
	public void save(MstStage mstStage) {
		mstStageRepository.save(mstStage);
		
		
	}

	@Override
	public Page<MstStage> findAllRecords(PageRequest pageRequest) {
		
		return mstStageRepository.findAll(pageRequest);
	}

	@Override
	public MstStage findOneById(Long sId) {
		return entityManager.find(MstStage.class, sId);
		
	}

	@Override
	public void deleteById(Long sId) {
		mstStageRepository.deleteById(sId);
		
	}

	@Override
	public Page<MstStage> completeSearch(String searchString, Pageable pageRequest) {
		return mstStageRepository.findAllByStageNameContainsOrDescriptionContainsAndIsActiveTrue(searchString,searchString, pageRequest);
	}
	}


