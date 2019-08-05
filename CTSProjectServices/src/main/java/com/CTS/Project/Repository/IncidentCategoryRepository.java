package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.IncidentCategory;




@Repository
public interface IncidentCategoryRepository extends JpaRepository<IncidentCategory, Integer>
{

	Page<IncidentCategory> findAllByIncidentcategoryNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(String ab,String disc,Pageable pageRequest);

	Page<IncidentCategory> findAllByIsActiveTrue(Pageable pageRequest);
			

	/*
	 * Iterable<IncidentCategory>
	 * findAllByIncidentCategoryNameAndDescriptionAndIsActiveTrue(String
	 * searchString, String searchString2, PageRequest pageRequest);
	 */
	//Page<IncidentCategory> findAllByIncidentCategoryNameAndDescriptionAndIsActiveTrue(String an,String disc,Pageable pageRequest);
	
	
	
	
}
