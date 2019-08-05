package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstPriority;


public interface MstPriorityService {
	
	void save(MstPriority mstpriority);

	MstPriority findById(Long priorityId);

	void deleteById(Long priorityId);
	
	List<MstPriority> getAllPriority();
	
	Page<MstPriority> findAllRecords(PageRequest pageRequest);

	Iterable<MstPriority> compliteSearch(String searchString, PageRequest pageRequest);

	Page<MstPriority> findAllRecordsByIsActive(Pageable pageRequest);

	
}
