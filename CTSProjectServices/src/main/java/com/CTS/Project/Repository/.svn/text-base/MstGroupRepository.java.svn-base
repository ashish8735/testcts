package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstGroup;

public interface MstGroupRepository extends JpaRepository<MstGroup, Long>{
	

	Page<MstGroup> findAllByGroupNameContainsAndIsActiveTrue(String groupName,Pageable pageRequest);
 

}
