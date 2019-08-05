package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.ApplicationTiming;




public interface ApplicationTimingRepository extends JpaRepository<ApplicationTiming , Long>
{

	
	Page<ApplicationTiming>findAllByMatApplicationIdApplicationNameContainsAndIsActiveTrue(String applicationName,Pageable pageRequest);
	
}
