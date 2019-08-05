package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.CTS.Project.Models.MstResourceZone;

public interface MstResourceZoneService {
	
	void save(MstResourceZone mstZone);
	Page<MstResourceZone> findAllRecords(PageRequest pageRequest);
	void deleteById(Long resourceZoneId);
	Page<MstResourceZone> completeSearch(String searchString,Pageable pageRequest);
	MstResourceZone checkUniqueRecord(String resourceZoneName);

}
