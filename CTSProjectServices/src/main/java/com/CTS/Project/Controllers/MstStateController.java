package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Models.MstState;
import com.CTS.Project.Services.MstStateService;

@RestController
@RequestMapping("/mstState")
public class MstStateController {
	
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstStateService stateService;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Page<MstState> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "zoneStateId") String col) {

		if (searchString == null || searchString.equals("")) {
			return stateService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return stateService.completeSearch( searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}
	
	@RequestMapping("create")
	public Map<String, String> create(@RequestBody MstState state) {
		if (state.getStateName() != null) {
			stateService.save(state);
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}
	
	
	@GetMapping
	@RequestMapping("listBySerach")
	public List<MstResourceZone> listBySerach(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceZoneId") String col) {

		if (searchString == null || searchString.equals("")) {
			return stateService.findAllByZoneRecords(page,size,sort,col);

		} else {

			return stateService.completeSearch(page,size,searchString,sort,col);

		}

	}
	

}
