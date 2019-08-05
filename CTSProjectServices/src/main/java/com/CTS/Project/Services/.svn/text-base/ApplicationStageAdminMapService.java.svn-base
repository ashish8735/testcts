package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.ApplicationStageAdminMap;
import com.CTS.Project.Models.MappingApplicationStage;

public interface ApplicationStageAdminMapService {
	
	void save(MappingApplicationStage mapAppicationstage);

	ApplicationStageAdminMap findById(Long stageadminId);

	void deleteById(Long stageadminId);	
		
	Page<ApplicationStageAdminMap> findAllRecords(PageRequest pageRequest);

	Page<ApplicationStageAdminMap> compliteSearch(String searchString, Pageable pageRequest);

	MappingApplicationStage getApplicationStage(Long appId, Long resourceId, Long stageId);
}
