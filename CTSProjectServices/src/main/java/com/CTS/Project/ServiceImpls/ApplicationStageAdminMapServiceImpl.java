package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.ApplicationStageAdminMap;
import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Repository.ApplicationStageAdminMapRepository;
import com.CTS.Project.Repository.MapApplicationStageRepository;
import com.CTS.Project.Repository.ResourceRoleMapRepository;
import com.CTS.Project.Services.ApplicationStageAdminMapService;

@Service
public class ApplicationStageAdminMapServiceImpl implements ApplicationStageAdminMapService{

	@Autowired
	EntityManager entitymanager;
	
	@Autowired
	ApplicationStageAdminMapRepository stageadminrepo;
	
	/*@Autowired
	MstApplicationRepository mstapprepo;
	*/
	@Autowired
	MapApplicationStageRepository applicationstageRepo;
	
	@Autowired
	ResourceRoleMapRepository resourceRolerepo;
	

	@Override
	public ApplicationStageAdminMap findById(Long stageadminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long stageadminId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ApplicationStageAdminMap> findAllRecords(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ApplicationStageAdminMap> compliteSearch(String searchString, Pageable pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MappingApplicationStage mapAppicationstage) {
		// TODO Auto-generated method stub
		applicationstageRepo.save(mapAppicationstage);
	}

	@Override
	public MappingApplicationStage getApplicationStage(Long appId, Long resourceId, Long stageId) {
		try {
			return entitymanager.createQuery("select p from MappingApplicationStage p where p.mapStageapplicationId.appId=" + appId
					+ " and p.mapresourceId.resourceId=" + resourceId + " and p.stageId.sId=" + stageId
					+ " and p.isActive=1", MappingApplicationStage.class).getSingleResult();
		} catch (Exception e) {
			return null;
		} 
	}

	
}
