package com.CTS.Project.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.ResourceRoleMap;

public interface MstResourcePoolService {
	void save(MstResourcePool resourcepool);

	Page<MstResourcePool> findAllRecords(PageRequest pageRequest);

	MstResourcePool findOneById(Long resourceId);

	void deleteById(Long resourceId);

	void save(List<MstResourcePool> mst);

	Page<MstResourcePool> completeSearch(String searchString, Pageable pageRequest);

	MstResourcePool findByLoginId(String lid);

	List<MstResourcePool> getAllApplicationResource(Long id);

	MstResourcePool findByresourceId(Long id);

	List<ResourceRoleMap> getUpperLevelResource(Long app_id, Long stage_id);
	List<ResourceRoleMap> getSameLevelResource(Long app_id, Long stage_id);


}
