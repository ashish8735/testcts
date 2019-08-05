package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Models.MstState;
import com.CTS.Project.Services.LocStateService;
import com.CTS.Project.Services.MstResourceZoneService;
import com.CTS.Project.Services.MstStateService;

@RestController
@RequestMapping("/locState")
public class LocStateController{
	Map<String, String> respMap = new HashMap<String, String>();
	
	@Autowired
	MstStateService stateService;
	
	@Autowired
	MstResourceZoneService resourceZoneService;
	
	@Autowired
	LocStateService locStateService;


	
	@RequestMapping("create")
	public Map<String, String> create(@RequestParam(value = "zoneId", required = false) long zoneId,@RequestBody MstResourceZone zone) {
		System.out.println("in svae---------------");
		
		MstResourceZone st = stateService.checkUniqueRecord(zoneId,
				zone.getZoneStateId().get(zone.getZoneStateId().size() - 1).getStateName());
		if (st == null) {
		if (zone.getZoneStateId().size()>0) {
			List<MstState> stateList=stateService.saveAll(zone.getZoneStateId());
			System.out.println("state==" + stateList.toString());
			zone.setZoneStateId(stateList);
			resourceZoneService.save(zone);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Record Already Exist.");
			return respMap;
		}
		}
	

	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Page<MstState> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceZoneId") String col) {

		if (searchString == null || searchString.equals("")) {
			return stateService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return stateService.completeSearch( searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}
	@PutMapping("delete/{stateId}")
	public Map<String, String> delete(@PathVariable("stateId") Long stateId) {
		if (stateId != 0) {
			stateService.deleteById(stateId);
			respMap.put("msg", "Operation Successful");
			respMap.put("success", "1");
		} else {
			respMap.put("msg", "Operation Failed");
			respMap.put("success", "0");
		}
		return respMap;
	}
	
}
