package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Models.RoleStageMap;

public interface RoleStageMapService {

	void save(RoleStageMap mstholiday);

	RoleStageMap findById(Long holidayId);

	void deleteById(Long holidayId);
	
	List<MstRole> getAllMstRole();
	
	List<MstStage> getAllmstStage();
	
	Page<RoleStageMap> findAllRecords(PageRequest pageRequest);

	Iterable<RoleStageMap> compliteSearch(String searchString, Pageable pageRequest);

	RoleStageMap checkexist(long roleId, long sId);


	
}
