package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstHoliday;

public interface MstHolidayService {

	void save(MstHoliday mstholiday);

	MstHoliday findById(Long holidayId);

	void deleteById(Long holidayId);
	
	List<MstApplication> getAllApplication();
	
	Page<MstHoliday> findAllRecords(PageRequest pageRequest);

	Iterable<MstHoliday> compliteSearch(String searchString, Pageable pageRequest);


}
