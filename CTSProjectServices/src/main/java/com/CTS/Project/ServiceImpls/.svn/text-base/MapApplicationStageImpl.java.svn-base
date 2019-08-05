package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Repository.MapApplicationStageRepository;
import com.CTS.Project.Repository.MstApplicationRepository;
import com.CTS.Project.Repository.MstStageRepository;
import com.CTS.Project.Services.MapApplicationStageService;

@Service
public class MapApplicationStageImpl implements MapApplicationStageService {

	@Autowired
	EntityManager entitymang;

	@Autowired
	MapApplicationStageRepository mapstagerepo;

	@Autowired
	MstApplicationRepository mstappication;

	@Autowired
	MstStageRepository mstStagerepo;

	@Override
	public void save(MappingApplicationStage mapapplicationstage) {
		mapstagerepo.save(mapapplicationstage);
	}

	@Override
	public MappingApplicationStage findById(Long application_stage_id) {
		// TODO Auto-generated method stub
		return entitymang.find(MappingApplicationStage.class, application_stage_id);
	}

	@Override
	public void deleteById(Long application_stage_id) {
		// TODO Auto-generated method stub
		mapstagerepo.deleteById(application_stage_id);

	}

	@Override
	public List<MstApplication> getAllApplication() {
		// TODO Auto-generated method stub
		return mstappication.findAll();
	}

	@Override
	public Page<MappingApplicationStage> findAllRecords(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return mapstagerepo.findAll(pageRequest);
	}

	@Override
	public Page<MappingApplicationStage> compliteSearch(String searchString, Pageable pageRequest) {
		return mapstagerepo
				.findAllByMapStageapplicationIdApplicationNameContainsOrStageIdStageNameContainsOrMapresourceIdResourceNameContainsAndIsActiveTrue(
						searchString, searchString,searchString, pageRequest);
	}

	@Override
	public List<MstStage> getAllmstStage() {
		return mstStagerepo.findAllByIsActiveTrue();
	}

	@Override
	@Transactional
	public MappingApplicationStage getExisitingRecordCheck(long appId, long getsId) {
		try {
			return entitymang
					.createQuery("select p from MappingApplicationStage p where p.mapStageapplicationId.appId=" + appId
							+ " and p.stageId.sId=" + getsId + " and isActive=1", MappingApplicationStage.class)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstApplication> getAllApplicationstage() {
		// TODO Auto-generated method stub
		// return mapstagerepo.findDistinctByMapStageapplicationIdAppId();
		String GETDISTIINCTAPPID = "SELECT * FROM mst_application app WHERE app.application_id IN (SELECT DISTINCT(app.application_id) FROM mapping_applicationstage mapstage WHERE mapstage.is_active=1) AND app.is_active=1";
		return entitymang.createNativeQuery(GETDISTIINCTAPPID, MstApplication.class).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstStage> getAllApplicationStage(Long id) {
		String GET_Resource_stage = "SELECT * FROM mapping_applicationstage mas,mst_stage ms WHERE mas.stage_id=ms.s_id AND mas.application_id='"
				+ id + "'";
		return entitymang.createNativeQuery(GET_Resource_stage, MstStage.class).getResultList();
	}

}
