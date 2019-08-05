package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.ResourceRoleMap;

public interface ResourceRoleMapService {
	
	void save(ResourceRoleMap resourceRoleMap);

	Page<ResourceRoleMap> findAllRecords(PageRequest pageRequest);

	ResourceRoleMap findOneById(String resourceRoleID);

	void deleteById(Long resourceRoleID);

	Iterable<ResourceRoleMap> completeSearch(String searchString,Pageable pageRequest);
	
	List<MstResourceType> getresourceTypeList();
	
	List<MstRole> getMstRoleList();
	
	List<MstApplication> getMstApplication();
	
	List<MstResourcePool> getMstResourcepoolById(Long resource_type_id);

	ResourceRoleMap checkUniqueRecord(long appId, Long resourceId, long roleId);

	List<ResourceRoleMap> getResourceListByAppId(long appId, long typeId);

}
