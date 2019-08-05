package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstRole;

public interface MstRoleRepository extends JpaRepository<MstRole, Long> {

	Page<MstRole> findAllByRoleNameContainsAndIsActiveTrueOrRoleGroupIDGroupNameContainsAndIsActiveTrue(String roleName,String groupName,Pageable pageRequest);

	Page<MstRole> findAllByIsActiveTrue(Pageable pageRequest);
}
