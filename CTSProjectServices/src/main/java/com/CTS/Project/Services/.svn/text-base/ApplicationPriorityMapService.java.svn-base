package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.ApplicationPriorityMap;

public interface ApplicationPriorityMapService {
	
	void save(ApplicationPriorityMap applicationPriorityMap);

	Page<ApplicationPriorityMap> findAllRecords(PageRequest pageRequest);

	ApplicationPriorityMap findOneById(Long applicationPriorityID);

	void deleteById(Long applicationPriorityID);

	Iterable<ApplicationPriorityMap> completeSearch(String searchString,Integer searchInt,Pageable pageRequest);

	ApplicationPriorityMap checkExist(long appId, long priorityId);
	

}
