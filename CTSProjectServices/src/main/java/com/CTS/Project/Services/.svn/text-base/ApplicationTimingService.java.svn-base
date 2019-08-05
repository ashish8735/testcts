package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.ApplicationTiming;



public interface ApplicationTimingService 
{

	void save(ApplicationTiming applicationTiming);

	Page<ApplicationTiming> findAllRecords(Pageable pageRequest);

	ApplicationTiming findOneById(Long applicationtimingId);

	void deleteById(Long applicationTimingId);

	Iterable<ApplicationTiming> compliteSearch(String searchString,Pageable pageRequest);
	
}
