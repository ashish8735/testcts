package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstApplication;

public interface MstApplicationService {

	void save(MstApplication mstApplication);

	Page<MstApplication> findAllRecords(PageRequest pageRequest);

	MstApplication findOneById(Long appId);

	void deleteById(Long appId);

	Page<MstApplication> compliteSearch(String searchString,Pageable pageRequest);

	Page<MstApplication> findAllRecordsByIsActive(Pageable pageRequest);

}
