package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.CTS.Project.Models.MstResourceType;
import com.CTS.Project.Services.MstResourceTypeService;

@RestController
@RequestMapping("/mstResourceType")
public class MstResourceTypeController {

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstResourceTypeService resourceTypeService;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Page<MstResourceType> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceTypeId") String col) {

		if (searchString == null || searchString.equals("")) {
			return resourceTypeService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return resourceTypeService.completeSearch( searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}
}
