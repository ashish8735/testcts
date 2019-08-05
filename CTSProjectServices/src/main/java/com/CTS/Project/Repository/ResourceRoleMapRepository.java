package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.ResourceRoleMap;

@Repository
public interface ResourceRoleMapRepository extends JpaRepository<ResourceRoleMap,Long>{
	
	Page<ResourceRoleMap>findAllByMtApplicationIdApplicationNameContainsOrMtRoleIdRoleNameContainsOrMResourceIdResourceNameContainsAndIsActiveTrue(String name,String rn,String resourcename,Pageable pageRequest);

	List<ResourceRoleMap> findByMtApplicationIdAppId(Long id);
}
