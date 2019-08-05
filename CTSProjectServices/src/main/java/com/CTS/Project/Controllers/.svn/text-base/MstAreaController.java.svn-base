package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.MstResourceArea;
import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Models.MstState;
import com.CTS.Project.Services.MstAreaService;
import com.CTS.Project.Services.MstResourceZoneService;
import com.CTS.Project.Services.MstStateService;

@RestController
@RequestMapping("/mstArea")
public class MstAreaController {
	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstAreaService areaService;

	@Autowired
	MstStateService mstStateService;

	@Autowired
	MstResourceZoneService mstResourceZoneService;

	@GetMapping
	@RequestMapping("list")
	public List<MstResourceZone> list(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceZoneId") String col) {

		if (searchString == null || searchString.equals("")) {
			return areaService.findAllByZoneRecords(page, size, sort, col);

		} else {

			return areaService.completeSearch(page, size, searchString, sort, col);

		}

	}

	@PostMapping("/create")
	public Map<String, String> create(@RequestBody MstState state) {
		System.out.println("state.getStateAreaId(----)" + state.getStateId());

		MstResourceZone st = areaService.checkUniqueRecord(state.getStateId(),
				state.getStateAreaId().get(state.getStateAreaId().size() - 1).getResourceAreaName());
		if (st == null) {
			if (state.getStateAreaId().size() > 0) {
				List<MstResourceArea> areaList = areaService.saveAll(state.getStateAreaId());
				state.setStateAreaId(areaList);
				mstStateService.save(state);
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
}
