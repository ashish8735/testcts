package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Repository.MstResourceRepository;
import com.CTS.Project.Security.PasswordUtil;
import com.CTS.Project.Services.MstResourcePoolService;

@Service
public class MstResourcePoolServiceImpl implements MstResourcePoolService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstResourceRepository resourceRepo;

	@Override
	public void save(MstResourcePool resourcepool) {
		resourcepool.setPassword(PasswordUtil.getPasswordHash(resourcepool.getPassword()));
		resourceRepo.save(resourcepool);
	}

	@Override
	public Page<MstResourcePool> findAllRecords(PageRequest pageRequest) {

		return resourceRepo.findAll(pageRequest);
	}

	@Override
	public MstResourcePool findOneById(Long resourceId) {

		return entityManager.find(MstResourcePool.class, resourceId);
	}

	@Override
	public void deleteById(Long resourceId) {
		resourceRepo.deleteById(resourceId);

	}

	@Override
	public Page<MstResourcePool> completeSearch(String searchString, Pageable pageRequest) {

		return resourceRepo
				.findAllByResourceNameContainsOrRpResourceDesignationTypeIdResourceDesignationNameContainsOrDepartmentContainsOrEmailIdContainsOrDealerCodeContainsOrBranchNameContainsOrMobileNoContainsOrFaxContainsAndIsActiveTrue(
						searchString, searchString, searchString, searchString, searchString, searchString,
						searchString, searchString, pageRequest);
	}
	
	@Override
	public void save(List<MstResourcePool> mst) {
		resourceRepo.saveAll(mst);
	}

	@Override
	public MstResourcePool findByLoginId(String lid) {
		
		return resourceRepo.findByLoginIdContaining(lid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstResourcePool> getAllApplicationResource(Long id) {
		String GET_Resource_stage="SELECT * FROM mapping_rolestage mrs,mapping_resourcerole mrr,mst_resource_pool pool WHERE mrs.role_id=mrr.mst_role_id AND mrr.mst_resource_id=pool.resource_id AND mrs.stage_id='"+id+"'";
		return entityManager.createNativeQuery(GET_Resource_stage, MstResourcePool.class).getResultList();	
	}
	@Override
	public MstResourcePool findByresourceId(Long id) {
		return resourceRepo.findByResourceId(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceRoleMap> getUpperLevelResource(Long app_id, Long stage_id) {
		String query="SELECT * FROM  mapping_resourcerole rr INNER JOIN mapping_rolestage mr ON mr.role_id=rr.mst_role_id  WHERE mr.stage_id=" + 
				"(SELECT s.stage_id FROM mapping_applicationstage s WHERE s.application_id="+app_id+" AND" + 
				"  s.configure_order>(SELECT s.configure_order" + 
				"	 FROM mapping_applicationstage s WHERE s.application_id="+app_id+" AND s.stage_id="+stage_id+") ORDER BY s.configure_order ASC LIMIT 1)";
		return entityManager.createNativeQuery(query, ResourceRoleMap.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceRoleMap> getSameLevelResource(Long app_id, Long stage_id) {
		String query="SELECT * FROM  mapping_resourcerole rr INNER JOIN mapping_rolestage mr ON mr.role_id=rr.mst_role_id WHERE mr.stage_id IN" + 
				"(SELECT s.stage_id FROM mapping_applicationstage s WHERE s.application_id="+app_id+" AND s.stage_id="+stage_id+")";
		return entityManager.createNativeQuery(query, ResourceRoleMap.class).getResultList();
	} 

}
