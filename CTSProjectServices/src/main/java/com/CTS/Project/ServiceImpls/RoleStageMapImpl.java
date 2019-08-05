package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Models.RoleStageMap;
import com.CTS.Project.Repository.MstRoleRepository;
import com.CTS.Project.Repository.MstStageRepository;
import com.CTS.Project.Repository.RoleStageMapRepository;
import com.CTS.Project.Services.RoleStageMapService;

@Service
public class RoleStageMapImpl implements RoleStageMapService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	RoleStageMapRepository rolestagemaprepo;
	
	@Autowired
	MstRoleRepository mstrolerepo;
	
	@Autowired
	MstStageRepository mststagerepo;
	
	
	@Override
	public void save(RoleStageMap rolestagemap) {
		rolestagemaprepo.save(rolestagemap);
		
	}

	@Override
	public RoleStageMap findById(Long rolestagemapid) {
		// TODO Auto-generated method stub
		return entityManager.find(RoleStageMap.class,rolestagemapid);
	}

	@Override
	public void deleteById(Long rolestagemapid) {
		rolestagemaprepo.deleteById(rolestagemapid);
		
	}

	@Override
	public List<MstRole> getAllMstRole() {
		// TODO Auto-generated method stub
		return mstrolerepo.findAll();
	}

	@Override
	public List<MstStage> getAllmstStage() {
		// TODO Auto-generated method stub
		return mststagerepo.findAll();
	}

	@Override
	public Page<RoleStageMap> findAllRecords(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return rolestagemaprepo.findAll(pageRequest);
	}

	@Override
	public Iterable<RoleStageMap> compliteSearch(String searchString, Pageable pageRequest) {
		// TODO Auto-generated method stub
		return rolestagemaprepo.findAllByMaproleIdRoleNameContainsOrStageIdStageNameContainsAndIsActiveTrue(searchString, searchString, pageRequest);
	}

	@Override
	public RoleStageMap checkexist(long roleId, long sId) {
		// TODO Auto-generated method stub
		try {
		return entityManager.createQuery("SELECT r FROM RoleStageMap r WHERE r.maproleId.roleId="+roleId+" AND r.stageId.sId="+sId+" AND r.isActive=1",RoleStageMap.class).getSingleResult();
		} catch (Exception e) {
			return null;
		} 
	}

}
