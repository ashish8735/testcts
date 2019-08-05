package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstStage;



public interface MstStageService {
	void save(MstStage mstStage);

	Page<MstStage> findAllRecords(PageRequest pageRequest);

	MstStage findOneById(Long sId);

	void deleteById(Long sId);

	Page<MstStage> completeSearch(String searchString,Pageable pageRequest);

}
