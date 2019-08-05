package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstResourceArea;

@Repository
public interface MstAreaRepository extends JpaRepository<MstResourceArea,Long> {
	Page<MstResourceArea>findAllByResourceAreaNameContainsOrResourceAreaDescriptionContainsAndIsActiveTrue(String name,String des,Pageable pageRequest);

}
