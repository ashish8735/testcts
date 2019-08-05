package com.CTS.Project.Controllers;

import java.util.HashMap;
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
import com.CTS.Project.Services.MstResourceZoneService;

@RestController
@RequestMapping("/mstResourceZone")
public class MstResourceZoneController {
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstResourceZoneService resourceZoneService;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Page<MstResourceZone> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceZoneId") String col) {

		if (searchString == null || searchString.equals("")) {
			return resourceZoneService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return resourceZoneService.completeSearch( searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}
	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstResourceZone zone) {
		
		MstResourceZone st = resourceZoneService.checkUniqueRecord(zone.getResourceZoneName());
		if (st == null) {
		if (zone.getResourceZoneName() != null) {
			resourceZoneService.save(zone);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
		}
		else {
			respMap.put("success", "0");
			respMap.put("msg", "Record Already Exist.");
			return respMap;
		}
	}
	@PutMapping("delete/{resourceZoneId}")
	public Map<String, String> delete(@PathVariable("resourceZoneId") Long resourceZoneId) {
		if (resourceZoneId != 0) {
			resourceZoneService.deleteById(resourceZoneId);
			respMap.put("msg", "Operation Successful");
			respMap.put("success", "1");
		} else {
			respMap.put("msg", "Operation Failed");
			respMap.put("success", "0");
		}
		return respMap;
	}

}
