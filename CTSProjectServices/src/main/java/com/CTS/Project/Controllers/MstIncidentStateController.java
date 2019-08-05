package com.CTS.Project.Controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.MstIncidentState;
import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Services.MstIncidentStateService;

@RestController
@RequestMapping("mstIcidentState")
public class MstIncidentStateController {
	
	@Autowired
	MstIncidentStateService mstIncidentStateService;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstIncidentState> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "incidentStateId") String col) {

		return mstIncidentStateService.findAllRecordsIsActive(new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size), Sort.Direction.fromString(sort), col));

	}
	@Transactional
	@GetMapping
	@RequestMapping("UpdateReportedstatus/{incident_id}/{currentUser}")
	public TranAddIncidentReview UpdateReportedstatus(@PathVariable("incident_id") long incident_id,@PathVariable("currentUser") long currentUser) {
		System.out.println("iddddddddddddddd"+incident_id);
		System.out.println("ccccccccccccc"+currentUser);

		return mstIncidentStateService.updateState(incident_id,currentUser);
		
	}

}
