package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Repository.MstResourceZoneRepository;
import com.CTS.Project.Services.MstResourceZoneService;

@Service
public class MstResourceZoneServiceImpl implements MstResourceZoneService {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstResourceZoneRepository resourceZoneRepo;

	@Override
	public Page<MstResourceZone> findAllRecords(PageRequest pageRequest) {
		
		return resourceZoneRepo.findAll(pageRequest);
	}

	@Override
	public Page<MstResourceZone> completeSearch(String searchString, Pageable pageRequest) {
		
		return resourceZoneRepo.findAllByResourceZoneNameContainsOrResourceZoneDescriptionContainsAndIsActiveTrue(searchString ,searchString, pageRequest);
	}

	@Override
	public void save(MstResourceZone mstZone) {
		 resourceZoneRepo.save(mstZone);
		
	}

	@Override
	public void deleteById(Long resourceZoneId) {
		resourceZoneRepo.deleteById(resourceZoneId);
		
	}

	@Override
	public MstResourceZone checkUniqueRecord(String resourceZoneName) {
		
		return entityManager.createQuery("select z from MstResourceZone z where z.resourceZoneName='"+resourceZoneName+"' and z.isActive=1",MstResourceZone.class).getSingleResult();
	}
	}


