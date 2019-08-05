package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.CTS.Project.Models.MstAppicationRoleMap;

public interface MstAppicationRoleMapService {

	void save(MstAppicationRoleMap mstAppicationRoleMap);

	Page<MstAppicationRoleMap> findAllRecords(PageRequest pageRequest);

	Page<MstAppicationRoleMap> compliteSearch(String searchString, PageRequest pageRequest);

	MstAppicationRoleMap findOneById(Long appilicationRoleId);

	void deleteById(Long appilicationRoleId);

	MstAppicationRoleMap checkRecordExists(long appId, long roleId);

	List<MstAppicationRoleMap> getListByRoleId(Long roleId);

	List<MstAppicationRoleMap> getListByResourceType(Long id);

}
