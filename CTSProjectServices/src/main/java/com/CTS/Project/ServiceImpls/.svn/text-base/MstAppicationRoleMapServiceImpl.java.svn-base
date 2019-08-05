package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstAppicationRoleMap;
import com.CTS.Project.Repository.MstAppicationRoleMapRepository;
import com.CTS.Project.Services.MstAppicationRoleMapService;

@Service
public class MstAppicationRoleMapServiceImpl implements MstAppicationRoleMapService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstAppicationRoleMapRepository mstAppicationRoleMapRepository;

	@Override
	public void save(MstAppicationRoleMap mstAppicationRoleMap) {
		mstAppicationRoleMapRepository.save(mstAppicationRoleMap);
	}

	@Override
	public Page<MstAppicationRoleMap> findAllRecords(PageRequest pageRequest) {
		return mstAppicationRoleMapRepository.findAll(pageRequest);
	}

	@Override
	public Page<MstAppicationRoleMap> compliteSearch(String searchString, PageRequest pageRequest) {
		return mstAppicationRoleMapRepository
				.findAllByApplicationMapApplicationIdApplicationNameContainsAndIsActiveTrueOrApplicationMapRoleIdRoleNameContainsAndIsActiveTrue(
						searchString, searchString, pageRequest);
	}

	@Override
	public MstAppicationRoleMap findOneById(Long appilicationRoleId) {
		return entityManager.find(MstAppicationRoleMap.class,appilicationRoleId);
	}

	@Override
	public void deleteById(Long appilicationRoleId) {
		mstAppicationRoleMapRepository.deleteById(appilicationRoleId);
	}

	@Override
	public MstAppicationRoleMap checkRecordExists(long appId, long roleId) {
		try {
			return entityManager.createQuery("select p from MstAppicationRoleMap p where p.applicationMapApplicationId.appId="+appId+" and p.applicationMapRoleId.roleId="+roleId+" and p.isActive=1",MstAppicationRoleMap.class).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<MstAppicationRoleMap> getListByRoleId(Long roleId) {
		return mstAppicationRoleMapRepository.findAllByApplicationMapRoleIdRoleIdAndIsActiveTrueAndApplicationMapRoleIdIsActiveTrue(roleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstAppicationRoleMap> getListByResourceType(Long id) {
		String query="select * from mapping_resourcerole rr inner join mst_appication_role_map am on rr.mst_role_id=am.application_map_role_id  " + 
				"inner join mst_application a on am.application_map_application_id=a.application_id  " + 
				"inner join mst_role r on am.application_map_role_id=r.role_id where rr.is_active=1 and am.is_active=1 and a.is_active=1 " + 
				"and r.is_active=1 and rr.mst_resource_type_id="+id;
		return entityManager.createNativeQuery(query,MstAppicationRoleMap.class).getResultList();
	}

}
