package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstIncidentType;
import com.CTS.Project.Repository.MstIncidentTypeRepository;
import com.CTS.Project.Services.MstIncidentTypeService;

@Service
public class MstIncidentTypeServiceImpl implements MstIncidentTypeService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstIncidentTypeRepository mstIncidentTypeRepository;

	@Override
	public void save(MstIncidentType mstIncidentType) {
		mstIncidentTypeRepository.save(mstIncidentType);
	}

	@Override
	public Page<MstIncidentType> findAllRecords(Pageable pageRequest) {
		return mstIncidentTypeRepository.findAllByIsActiveTrue(pageRequest);
	}

	@Override
	public Iterable<MstIncidentType> compliteSearch(String searchString,Pageable pageRequest) {
		return mstIncidentTypeRepository.findAllByIncidentTypeApplicationIdApplicationNameContainsAndIsActiveTrueOrIncidentTypeNameContainsAndIsActiveTrue(searchString, searchString, pageRequest);
	}

	@Override
	public MstIncidentType findOneById(Long appId) {
		return entityManager.find(MstIncidentType.class, appId);
	}

	@Override
	public void deleteById(Long appId) {
		mstIncidentTypeRepository.deleteById(appId);
	}

	@Override
	public List<MstIncidentType> getAllRecordByApplicationId(long appId) {
		return mstIncidentTypeRepository.findAllByIncidentTypeApplicationIdAppIdAndIsActiveTrue(appId);
	}

	@Override
	public Page<MstIncidentType> findAllRecordsByIsActive(Pageable pageRequest) {
		return mstIncidentTypeRepository.findAllByIsActiveTrue(pageRequest);
	}

}
