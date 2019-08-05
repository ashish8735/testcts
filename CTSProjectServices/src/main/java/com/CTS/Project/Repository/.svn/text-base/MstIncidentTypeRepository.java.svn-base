package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstIncidentType;

public interface MstIncidentTypeRepository extends JpaRepository<MstIncidentType, Long> {

	Page<MstIncidentType> findAllByIsActiveTrue(Pageable pageRequest);

	Page<MstIncidentType> findAllByIncidentTypeApplicationIdApplicationNameContainsAndIsActiveTrueOrIncidentTypeNameContainsAndIsActiveTrue(
			String appName, String typeName,Pageable pageRequest);
	
	List<MstIncidentType> findAllByIncidentTypeApplicationIdAppIdAndIsActiveTrue(long appId);
}
