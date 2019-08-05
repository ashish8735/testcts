package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.ApplicationPriorityMap;

@Repository
public interface ApplicationPriorityMapRepository extends JpaRepository<ApplicationPriorityMap,Long>{
	
	Page<ApplicationPriorityMap>findAllByMapApplicationIdApplicationNameContainsOrMapPriorityIdPriorityNameContainsOrConfigureOrderAndIsActiveTrue(String name,String pn,Integer co,Pageable pageRequest);

	

}
