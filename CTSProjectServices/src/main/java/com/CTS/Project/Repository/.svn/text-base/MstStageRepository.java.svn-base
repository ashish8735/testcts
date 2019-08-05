package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstStage;


public interface MstStageRepository extends JpaRepository<MstStage, Long> {
		Page<MstStage> findAllByStageNameContainsOrDescriptionContainsAndIsActiveTrue(String sn,String disc,Pageable pageRequest);

		List<MstStage> findAllByIsActiveTrue();
		 


}
