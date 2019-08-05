package com.CTS.Project.ServiceImpls;

import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Services.UpdateIncidentService;

@Repository
public class UpdateIncidentServiceImpl implements UpdateIncidentService {

	@Override
	public void update(TranAddIncidentReview tran, String fileurl) {
		System.out.println("tran==" + tran.toString());
		// TODO Auto-generated method stub
		
	}

}
