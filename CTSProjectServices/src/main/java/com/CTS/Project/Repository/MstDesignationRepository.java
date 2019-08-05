package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstResourceDesignation;

@Repository
public interface MstDesignationRepository extends JpaRepository<MstResourceDesignation,Long>{
	
	Page<MstResourceDesignation>findAllByResourceDesignationNameContainsOrDescriptionContainsAndIsActiveTrue(String name,String des,Pageable pageRequest);

}
