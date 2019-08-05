package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstResourceType;

@Repository
public interface MstResourceTypeRepository extends JpaRepository<MstResourceType,Long  > {
	
	Page<MstResourceType> findAllByResourceTypeNameContainsAndIsActiveTrue(String name,Pageable pageRequest);

	List<MstResourceType> findAllByIsActiveTrue();

}
