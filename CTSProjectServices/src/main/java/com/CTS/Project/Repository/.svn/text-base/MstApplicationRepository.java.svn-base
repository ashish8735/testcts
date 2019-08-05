package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstApplication;


public interface MstApplicationRepository extends JpaRepository<MstApplication, Long>{

	Page<MstApplication> findAllByIsActiveTrue(Pageable pageRequest);
	
	Page<MstApplication> findAllByAbbreviationNameContainsAndIsActiveTrueOrApplicationNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(String ab,String an,String disc,Pageable pageRequest);
 
}
