package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Services.ApplicationStageAdminMapService;
import com.CTS.Project.Services.MapApplicationStageService;

@RestController
@RequestMapping("application_stageadmin")
public class ApplicationStageAdminMapController {
	
	Map<String, String> respMap = new HashMap<String, String>();


	@Autowired
	MapApplicationStageService applstage;
	
	@Autowired
	ApplicationStageAdminMapService appStageAdminService;
	
	
	@Autowired
	ExcelGenerator excelGenerator;
	
	@PostMapping("/add")
	public Map<String, String> add(@RequestBody MappingApplicationStage mapAppicationstage)
	{		
		Long appId=mapAppicationstage.getMapStageapplicationId().getAppId();
		Long resourceId=mapAppicationstage.getMapresourceId().getResourceId();
		Long stageId=mapAppicationstage.getStageId().getsId();
		
		
		MappingApplicationStage obj=appStageAdminService.getApplicationStage(appId,resourceId,stageId);
		if(obj==null) {
		if (mapAppicationstage.getMapStageapplicationId().getAppId() != 0) {
			appStageAdminService.save(mapAppicationstage);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
		}
		else
		{
			respMap.put("success", "0");
			respMap.put("msg", "Record already exist");
			return respMap;
		}
	}
	
		
	

	
	
}
