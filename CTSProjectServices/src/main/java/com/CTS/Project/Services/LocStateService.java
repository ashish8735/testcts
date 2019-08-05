package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.LocState;



public interface LocStateService {
	void save(LocState ls);
	Page<LocState> findAllRecords(PageRequest pageRequest);
	void deleteById(Long stateId);
	Page<LocState> completeSearch(String searchString,Pageable pageRequest);


}
