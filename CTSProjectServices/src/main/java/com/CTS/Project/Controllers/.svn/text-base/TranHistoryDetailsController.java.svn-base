package com.CTS.Project.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.TranHistoryDetails;
import com.CTS.Project.Services.TranHistoryDetailsService;


@RestController
@RequestMapping("historydetails")
public class TranHistoryDetailsController {
	
	@Autowired
	TranHistoryDetailsService tranHistoryDetailsService; 
	
	@GetMapping
	@RequestMapping("getHistoryDetailsList/{incidentReviewId}")
	public List<TranHistoryDetails> getReminderDetailsList(@PathVariable("incidentReviewId") Long incidentReviewId) {
		return tranHistoryDetailsService.getReminderDetailsList(incidentReviewId);	
	}
}
