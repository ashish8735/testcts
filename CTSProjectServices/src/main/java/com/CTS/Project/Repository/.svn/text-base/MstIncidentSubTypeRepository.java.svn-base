package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstIncidentSubType;

public interface MstIncidentSubTypeRepository extends JpaRepository<MstIncidentSubType, Long> {

	Page<MstIncidentSubType> findAllByIsActiveTrue(Pageable pageRequest);
	
	Page<MstIncidentSubType> findAllByIncidentSubTypeIncidenceIdIncidentTypeNameContainsOrIncidentSubTypeIncidenceIdIncidentTypeApplicationIdApplicationNameContainsOrIncidentSubTypeNameContainsAndIsActiveTrue(String incidenceType,String appName,String incidentSubType,Pageable pageRequest);

	List<MstIncidentSubType> findByIncidentSubTypeIncidenceIdIncidentTypeIdAndIsActiveTrue(long incidentTypeId);

}
