package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstAppicationRoleMap;

public interface MstAppicationRoleMapRepository extends JpaRepository<MstAppicationRoleMap, Long> {

	Page<MstAppicationRoleMap> findAllByApplicationMapApplicationIdApplicationNameContainsAndIsActiveTrueOrApplicationMapRoleIdRoleNameContainsAndIsActiveTrue(String applicationName,String roleName,Pageable pageRequest);

	List<MstAppicationRoleMap> findAllByApplicationMapRoleIdRoleIdAndIsActiveTrueAndApplicationMapRoleIdIsActiveTrue(
			Long roleId);
}
