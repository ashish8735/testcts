package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.CTS.Project.Models.MstResourceArea;
import com.CTS.Project.Models.MstResourceZone;


public interface MstAreaService {
	
	void save(MstResourceArea area);
	Page<MstResourceArea> findAllRecords(PageRequest pageRequest);

//	Page<MstResourceZone> completeSearch(String searchString,Pageable pageRequest);
	
	List<MstResourceArea> saveAll(List<MstResourceArea> area);
	
	List<MstResourceZone> findAllByZoneRecords(String page, String size, String sort, String col);
	
	List<MstResourceZone> completeSearch(String page, String size, String sort, String col, String col2);

	
	MstResourceZone checkUniqueRecord(long stateAreaId, String resourceAreaName);
	 
}
