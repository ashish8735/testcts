package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstIncidentSubType;

public interface MstIncidentSubTypeService {

	void save(MstIncidentSubType mstIncidentSubType);

	Page<MstIncidentSubType> findAllRecords(Pageable pageRequest);

	Page<MstIncidentSubType> compliteSearch(String searchString, Pageable pageRequest);

	MstIncidentSubType findOneById(Long appId);

	void deleteById(Long appId);

	List<MstIncidentSubType> getAllRecordByIncidentTypeId(long incidentTypeId);

}
