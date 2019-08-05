package com.CTS.Project.Services;

import org.springframework.stereotype.Service;

import com.CTS.Project.Models.TranAddIncidentReview;

@Service
public interface UpdateIncidentService {

	void update(TranAddIncidentReview tran, String fileurl);

}
