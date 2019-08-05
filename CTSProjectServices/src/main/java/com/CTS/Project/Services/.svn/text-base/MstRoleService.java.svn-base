package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstRole;

public interface MstRoleService {

	void save(MstRole mstRole);

	Page<MstRole> findAllRecords(PageRequest pageRequest);

	Page<MstRole> compliteSearch(String searchString, PageRequest pageRequest);

	MstRole findOneById(Long appId);

	void deleteById(Long appId);

	Page<MstRole> findAllRecordsByIsActive(Pageable pageRequest);

}
