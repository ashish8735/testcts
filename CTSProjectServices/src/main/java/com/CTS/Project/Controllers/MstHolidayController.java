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
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstHoliday;
import com.CTS.Project.Services.MstHolidayService;

@RestController
@RequestMapping("mstholiday")
public class MstHolidayController {
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstHolidayService mstholidayserv;
	
	@Autowired
	ExcelGenerator excelGenerator;
	
	/*	Add Holiday*/
	@PostMapping("/add")
	public Map<String, String> addholiday(@RequestBody MstHoliday mstholiday)
	{			
		if(mstholiday.getReasonofHoliday()!="")
		{
			mstholidayserv.save(mstholiday);
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
		
	}
	
	/*Delete priority By ID*/
	@PutMapping("delete/{holidayId}")
	public Map<String, String> deleteById(@PathVariable Long holidayId)
	{		
		if(holidayId!=0)
		{
			mstholidayserv.deleteById(holidayId);
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

	/*Get data By Id*/
	@GetMapping("editpriority/{Id}")
	public MstHoliday editById(@PathVariable Long Id)
	{
		return mstholidayserv.findById(Id);
			
	}

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstHoliday> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "holidayId") String col) {

		if (searchString == null || searchString.equals("")) {
			System.out.println();
			return mstholidayserv.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {
			System.out.println();
			return mstholidayserv.compliteSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));
		}
			
		}
		
		@GetMapping("applicationlist")
		public List<MstApplication> getListOfMstapplication()
		{
			List<MstApplication> prioritylist=mstholidayserv.getAllApplication();
			
			return prioritylist;
		}
		
		@RequestMapping("mstHolidayExcelExport")
		public ResponseEntity<InputStreamResource> customeExport()
				throws IOException {
			
			String query="select a.holiday_id ,a.holiday_date,a.reasonof_holiday,(case when (CAST(a.is_active AS UNSIGNED INTEGER) = 1) THEN 'Active' ELSE 'In-Active' END) from mst_holiday a";
			String headerNames="Holiday Id,Holiday Date,Reason Of Holiday,Is Active";

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=holiday.xlsx");
			return ResponseEntity.ok().headers(headers)
					.body(new InputStreamResource(excelGenerator.createCustoneExcel(headerNames, query, "Holiday")));

		}

}
