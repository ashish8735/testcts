package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MappingIncidentCatagory;

public interface MappingIncidentCategoryService 
{

	void save(MappingIncidentCatagory mappingIncidentCatagory);

	Page<MappingIncidentCatagory> findAllRecords(Pageable pageRequest);

	MappingIncidentCatagory findOneById(Long mapincidentCatagoryId);

	void deleteById(Long mapincidentCatagoryId);

	Iterable<MappingIncidentCatagory> compliteSearch(String searchString,Pageable pageRequest);

	List<MappingIncidentCatagory> getIncidentCategory(long app_id);
}
