package com.CTS.Project.Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.ExcelGenerator;
import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstStage;
import com.CTS.Project.Services.MapApplicationStageService;

@RestController
@RequestMapping("mapapplicationstage")
public class MapApplicationStageController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MapApplicationStageService mapapplicationservice;
	
	@Autowired
	ExcelGenerator excelGenerator;
	
	@PostMapping("/add")
	public Map<String, String> addpriority(@RequestBody MappingApplicationStage mapAppicationstage)
	{		
		MappingApplicationStage obj=mapapplicationservice.getExisitingRecordCheck(mapAppicationstage.getMapStageapplicationId().getAppId(),mapAppicationstage.getStageId().getsId());
		if(obj==null) {
			if(mapAppicationstage.getConfigureOrder()!=0)
			{
				mapapplicationservice.save(mapAppicationstage);
				respMap.put("success", "1");
				respMap.put("msg", "Process Completed Successfully");
				return respMap;		
			}
			else
			{			
				respMap.put("success", "0");
				respMap.put("msg", "Failed To Add Null Field");
				return respMap;
			}
		}else {
			respMap.put("success", "0");
			respMap.put("msg", "Record Already Exist");
			return respMap;
		}
	
		
	}
	
	
	@PutMapping("delete/{application_stage_Id}")
	public Map<String, String> deleteById(@PathVariable Long application_stage_Id)
	{
		System.out.println("holidayId--------------------"+application_stage_Id);
		if(application_stage_Id!=0)
		{
			mapapplicationservice.deleteById(application_stage_Id);
			respMap.put("success", "1");
			respMap.put("msg", "Removed Successfully");
			return respMap;
		}
		else
		{
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Delete Null Field");
			return respMap;	
		}
	}

	
	@GetMapping("editpriority/{Id}")
	public MappingApplicationStage editById(@PathVariable Long Id)
	{
		return mapapplicationservice.findById(Id);
			
	}

	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MappingApplicationStage> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "applicationStageId") String col) {

		if (searchString == null || searchString.equals("")) {
			System.out.println();
			return mapapplicationservice.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {
			System.out.println();
			return mapapplicationservice.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));
		}
			
		}
		
		@GetMapping("applicationlist")
		public List<MstApplication> getListOfMstapplication()
		{
			List<MstApplication> appicationlist=mapapplicationservice.getAllApplication();
			
			return appicationlist;
		}
		
		@GetMapping("stagelist")
		public List<MstStage> getListOfMstStage()
		{
			List<MstStage> stagelist=mapapplicationservice.getAllmstStage();
			
			return stagelist;
		}
	
		@RequestMapping("mapapplicationStageExls")
		public ResponseEntity<InputStreamResource> customeExport()
				throws IOException {
			
			String query="SELECT a.application_stage_id,appl.application_name,stage.stage_name,a.configure_order,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) AS IsActive from mapping_applicationstage a JOIN mst_application appl ON a.application_id=appl.application_id JOIN mst_stage stage ON a.stage_id=stage.s_id";
			String headerNames="Id,Application Name,Stage Name,Configure Order,Is Active";

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=map_ApplStage.xlsx");
			return ResponseEntity.ok().headers(headers)
					.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Map Application Stage")));

		}
		
		@GetMapping("app_applicationlist")
		public List<MstApplication> getListOfMstapplicationstage()
		{			
			List<MstApplication> appicationlist=mapapplicationservice.getAllApplicationstage();			
			return appicationlist;
		}
		
		/*@GetMapping("appResourcelist/{id}")
		public List<MstResourcePool> getListOfMstResource(@PathVariable Long id)
		{
			List<MstResourcePool> stagelist=mapapplicationservice.getAllApplicationResource(id);
			
			return stagelist;
		}*/
		
		@GetMapping("appstagelist/{id}")
		public List<MstStage> getListOfMstStage(@PathVariable Long id)
		{
			List<MstStage> stagelist=mapapplicationservice.getAllApplicationStage(id);
			
			return stagelist;
		}

		
		
}
