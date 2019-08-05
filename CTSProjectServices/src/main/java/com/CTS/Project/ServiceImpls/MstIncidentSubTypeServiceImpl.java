package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstIncidentSubType;
import com.CTS.Project.Repository.MstIncidentSubTypeRepository;
import com.CTS.Project.Services.MstIncidentSubTypeService;

@Service
public class MstIncidentSubTypeServiceImpl implements MstIncidentSubTypeService{

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstIncidentSubTypeRepository mstIncidentSubTypeRepository;

	@Override
	public void save(MstIncidentSubType mstIncidentSubType) {
		mstIncidentSubTypeRepository.save(mstIncidentSubType);
	}

	@Override
	public Page<MstIncidentSubType> findAllRecords(Pageable pageRequest) {
		return mstIncidentSubTypeRepository.findAllByIsActiveTrue(pageRequest);
	}

	@Override
	public Page<MstIncidentSubType> compliteSearch(String searchString, Pageable pageRequest) {
		return mstIncidentSubTypeRepository.findAllByIncidentSubTypeIncidenceIdIncidentTypeNameContainsOrIncidentSubTypeIncidenceIdIncidentTypeApplicationIdApplicationNameContainsOrIncidentSubTypeNameContainsAndIsActiveTrue(searchString, searchString, searchString, pageRequest);
	}

	@Override
	public MstIncidentSubType findOneById(Long appId) {
		return entityManager.find(MstIncidentSubType.class, appId);
	}

	@Override
	public void deleteById(Long appId) {
		mstIncidentSubTypeRepository.deleteById(appId);
	}

	@Override
	public List<MstIncidentSubType> getAllRecordByIncidentTypeId(long incidentTypeId) {
		// TODO Auto-generated method stub
		return mstIncidentSubTypeRepository.findByIncidentSubTypeIncidenceIdIncidentTypeIdAndIsActiveTrue(incidentTypeId);
	}

}
