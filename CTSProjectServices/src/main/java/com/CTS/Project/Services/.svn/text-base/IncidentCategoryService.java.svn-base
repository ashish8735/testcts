package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.IncidentCategory;




public interface IncidentCategoryService 
{

	void save(IncidentCategory incidentCategory);

	Page<IncidentCategory> findAllRecords(PageRequest pageRequest);

	IncidentCategory findOneById(Integer incidentcategoryId);

	void deleteById(Integer incidentcategoryId);

	Iterable<IncidentCategory> compliteSearch(String searchString, PageRequest pageRequest);

	Page<IncidentCategory> findAllRecordsByIsActive(Pageable pageRequest);

//	Page<IncidentCategory> compliteSearch(String searchString,Pageable pageRequest);

	
	
	
}
