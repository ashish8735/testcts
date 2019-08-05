package com.CTS.Project.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstHoliday;

public interface MstHolidayRepository extends JpaRepository<MstHoliday, Long> {

	public Page<MstHoliday> findAllByReasonofHolidayContainsAndIsActiveTrueOrHolidayApplicationIdApplicationNameContainsAndIsActiveTrue(String reason,String name,Pageable pageRequest);

}


