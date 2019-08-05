package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.CTS.Project.Models.MstGroup;

public interface MstGroupService {

	Page<MstGroup> findAllRecords(PageRequest pageRequest);

	Page<MstGroup> compliteSearch(String searchString, PageRequest pageRequest);

	void deleteById(Long groupId);

	MstGroup findOneById(Long groupId);

	void save(MstGroup mstgroup);

}
