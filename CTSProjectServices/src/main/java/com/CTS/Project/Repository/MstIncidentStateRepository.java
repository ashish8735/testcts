package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.MstIncidentState;

public interface MstIncidentStateRepository extends JpaRepository<MstIncidentState, Long>{
	
	Page<MstIncidentState> findAllByIsActiveTrue(Pageable page);
	

}
