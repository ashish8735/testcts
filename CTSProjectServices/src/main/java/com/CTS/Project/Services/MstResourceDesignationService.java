package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstResourceDesignation;
import com.CTS.Project.Models.MstResourceType;

public interface MstResourceDesignationService {
	void save( MstResourceDesignation resourcedesignation);
	Page< MstResourceDesignation> findAllRecords(PageRequest pageRequest);

	MstResourceType findOneById(Long resourceDesignationId);

	void deleteById(Long resourceDesignationId);

	Page<MstResourceDesignation> completeSearch(String searchString,Pageable pageRequest);


}
