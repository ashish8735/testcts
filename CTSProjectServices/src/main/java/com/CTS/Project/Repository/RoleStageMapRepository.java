package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.RoleStageMap;

public interface RoleStageMapRepository extends JpaRepository<RoleStageMap, Long> {
	
	Page<RoleStageMap> findAllByMaproleIdRoleNameContainsOrStageIdStageNameContainsAndIsActiveTrue(
			String searchString, String searchString2,Pageable pageRequest);

}
