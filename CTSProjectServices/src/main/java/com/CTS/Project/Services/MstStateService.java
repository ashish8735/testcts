package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Models.MstState;

public interface MstStateService {
	void save(MstState state);
	Page<MstState> findAllRecords(PageRequest pageRequest);

	Page<MstState> completeSearch(String searchString,Pageable pageRequest);
	void deleteById(Long stateId);
	List<MstState> saveAll(List<MstState> state);
	
    List<MstResourceZone> findAllByZoneRecords(String page, String size, String sort, String col);
	List<MstResourceZone> completeSearch(String page, String size, String sort, String col, String col2);
	
	MstResourceZone checkUniqueRecord(long zoneId, String stateName);
	  
	  
	 
}
