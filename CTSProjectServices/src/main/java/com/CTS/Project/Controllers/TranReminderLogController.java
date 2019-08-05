package com.CTS.Project.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Models.TranReminderLog;
import com.CTS.Project.Services.TranReminderLogService;


@RestController
@RequestMapping("reminderlog")
public class TranReminderLogController {
	
	@Autowired
	TranReminderLogService tranReminderLogService ;
	
	@GetMapping
	@RequestMapping("getIncidentReviewObj/{reviewId}")
	public TranAddIncidentReview getIncidentReviewObj(@PathVariable("reviewId") Long reviewId) {
		System.out.println("reviewId" + reviewId);
		return tranReminderLogService.getIncidentReviewObject(reviewId);	
	}
	
	@PostMapping
	@RequestMapping("getReminderLogObj")
	public TranReminderLog getReminderLogObj(@RequestBody TranReminderLog tranReminderLog) {		
		System.out.println("Remark==" + tranReminderLog.getReminderId());
		System.out.println("Remark==" + tranReminderLog.getPendingAt());
		return tranReminderLogService.saveData(tranReminderLog);
	}
	
	@GetMapping
	@RequestMapping("getReminderDetailsList/{incidentReviewId}")
	public List<TranReminderLog> getReminderDetailsList(@PathVariable("incidentReviewId") Long incidentReviewId) {
		System.out.println("reviewId==" + incidentReviewId);
		return tranReminderLogService.getReminderDetailsList(incidentReviewId);	
	}
}
