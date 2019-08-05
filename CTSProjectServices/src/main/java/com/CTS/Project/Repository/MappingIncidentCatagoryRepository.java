package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MappingIncidentCatagory;

public interface MappingIncidentCatagoryRepository extends JpaRepository<MappingIncidentCatagory, Long> 

{
	
	
	//Page<ApplicationTiming>findAllByMattApplicationIdMatincidentcategoryIdApplicationNameContainsAndIsActiveTrue(String applicationName,Pageable pageRequest);
	
	Page<MappingIncidentCatagory>findAllByMicApplicationIdApplicationNameContainsAndIsActiveTrueOrMicIncidentcategoryIdIncidentcategoryNameContainsAndIsActiveTrue(String applicationName,String incidentName,Pageable pageRequest);
	
}
