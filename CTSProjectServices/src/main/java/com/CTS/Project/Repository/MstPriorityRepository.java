package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstPriority;

@Repository
public interface MstPriorityRepository extends JpaRepository<MstPriority, Long>{

	public Page<MstPriority> findAllByPriorityNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(String searchString,String desc,Pageable pageRequest);

	public Page<MstPriority> findAllByIsActiveTrue(Pageable pageRequest);
		 
	
}
