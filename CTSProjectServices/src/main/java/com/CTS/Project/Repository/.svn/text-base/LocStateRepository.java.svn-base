package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.LocState;


@Repository
public interface LocStateRepository extends JpaRepository<LocState,Long>{
	Page<LocState>findAllByMstresourceZoneIdResourceZoneNameContainsOrStateNameContainsAndIsActiveTrue(String zname,String sname,Pageable pageRequest);
	
}
