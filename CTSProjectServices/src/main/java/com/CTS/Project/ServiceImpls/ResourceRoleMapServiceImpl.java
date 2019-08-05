package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Repository.MstApplicationRepository;
import com.CTS.Project.Repository.MstResourceRepository;
import com.CTS.Project.Repository.MstResourceTypeRepository;
import com.CTS.Project.Repository.MstRoleRepository;
import com.CTS.Project.Repository.ResourceRoleMapRepository;
import com.CTS.Project.Services.ResourceRoleMapService;

@Service
public class ResourceRoleMapServiceImpl implements ResourceRoleMapService {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ResourceRoleMapRepository rmp;

	@Autowired
	MstRoleRepository rolerepo;

	@Autowired
	MstApplicationRepository applicationrepo;

	@Autowired
	MstResourceTypeRepository resourcetyperepo;

	@Autowired
	MstResourceRepository resourcePoolrepo;

	@Override
	public void save(ResourceRoleMap resourceRoleMap) {
		rmp.save(resourceRoleMap);

	}

	@Override
	public Page<ResourceRoleMap> findAllRecords(PageRequest pageRequest) {

		return rmp.findAll(pageRequest);
	}

	@Override
	public ResourceRoleMap findOneById(String resourceRoleID) {

		return entityManager.find(ResourceRoleMap.class, resourceRoleID);

	}

	@Override
	public void deleteById(Long resourceRoleID) {
		rmp.deleteById(resourceRoleID);

	}

	@Override
	public Iterable<ResourceRoleMap> completeSearch(String searchString, Pageable pageRequest) {

		return rmp
				.findAllByMtApplicationIdApplicationNameContainsOrMtRoleIdRoleNameContainsOrMResourceIdResourceNameContainsAndIsActiveTrue(
						searchString, searchString, searchString, pageRequest);

	}

	@Override
	public List<MstResourceType> getresourceTypeList() {
		return resourcetyperepo.findAllByIsActiveTrue();
	}

	@Override
	public List<MstRole> getMstRoleList() {
		return rolerepo.findAll();
	}

	@Override
	public List<MstApplication> getMstApplication() {
		return applicationrepo.findAll();
	}

	@Override
	public List<MstResourcePool> getMstResourcepoolById(Long resource_type_id) {
		return resourcePoolrepo.findAllByRpResourceTypeIdResourceTypeId(resource_type_id);
	}

	@Override
	public ResourceRoleMap checkUniqueRecord(long appId, Long resourceId, long roleId) {		
		try {
			return entityManager.createQuery("select p from ResourceRoleMap p where p.mtApplicationId.appId=" + appId
					+ " and p.mResourceId.resourceId=" + resourceId + " and p.mtRoleId.roleId=" + roleId
					+ " and p.isActive=1", ResourceRoleMap.class).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceRoleMap> getResourceListByAppId(long appId,long typeId) {
		String query="select * from mapping_resourcerole rr inner join mst_appication_role_map am on rr.mst_role_id=am.application_map_role_id \r\n" + 
				"where rr.is_active=1 and am.is_active=1 and am.application_map_application_id="+appId+" and mst_resource_type_id="+typeId;
		return entityManager.createNativeQuery(query,ResourceRoleMap.class).getResultList();
	}

}
