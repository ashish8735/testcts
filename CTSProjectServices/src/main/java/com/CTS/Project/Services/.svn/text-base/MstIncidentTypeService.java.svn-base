package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstIncidentType;

public interface MstIncidentTypeService {

	void save(MstIncidentType mstIncidentType);

	Page<MstIncidentType> findAllRecords(Pageable pageRequest);

	Iterable<MstIncidentType> compliteSearch(String searchString, Pageable pageRequest);

	MstIncidentType findOneById(Long appId);

	void deleteById(Long appId);

	List<MstIncidentType> getAllRecordByApplicationId(long appId);

	Page<MstIncidentType> findAllRecordsByIsActive(Pageable pageRequest);

}
