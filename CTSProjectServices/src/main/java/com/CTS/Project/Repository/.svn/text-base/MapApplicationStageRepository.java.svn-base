package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MappingApplicationStage;
@Repository
public interface MapApplicationStageRepository extends JpaRepository<MappingApplicationStage, Long>{

	Page<MappingApplicationStage> findAllByMapStageapplicationIdApplicationNameContainsOrStageIdStageNameContainsOrMapresourceIdResourceNameContainsAndIsActiveTrue(
			String searchString, String searchString2,String searchString3,Pageable pageRequest);

	List<MappingApplicationStage> findByMapStageapplicationIdAppId(Class<MappingApplicationStage> class1, long appId);

	//List<MappingApplicationStage> findByMapStageapplicationIdAppId(Long id);

	//List<MappingApplicationStage> findDistinctByMapStageapplicationIdAppId();

}
