package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstStage;
public interface MapApplicationStageService {

	void save(MappingApplicationStage mstholiday);

	MappingApplicationStage findById(Long holidayId);

	void deleteById(Long holidayId);
	
	List<MstApplication> getAllApplication();
	
	List<MstStage> getAllmstStage();
	
	Page<MappingApplicationStage> findAllRecords(PageRequest pageRequest);

	Page<MappingApplicationStage> compliteSearch(String searchString, Pageable pageRequest);

	MappingApplicationStage getExisitingRecordCheck(long appId, long getsId);
	
	List<MstApplication> getAllApplicationstage();
	
	List<MstStage> getAllApplicationStage(Long id);

	//List<MstResourcePool> getAllApplicationResource(Long id);

	//List<MappingApplicationStage> getAllApplicationStage(Long id);s

}
