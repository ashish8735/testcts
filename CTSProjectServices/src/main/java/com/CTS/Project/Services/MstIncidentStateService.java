package com.CTS.Project.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CTS.Project.Models.MstIncidentState;
import com.CTS.Project.Models.TranAddIncidentReview;

public interface MstIncidentStateService {

	Page<MstIncidentState> findAllRecordsIsActive(Pageable pageRequest);

	TranAddIncidentReview updateState(long incident_id,long currentUser);

}
