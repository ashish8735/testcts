package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.MstResourceDesignation;
import com.CTS.Project.Services.MstResourceDesignationService;

@RestController
@RequestMapping("/mstResourceDesignation")
public class MstResourceDesignationController {
	

	Map<String, String> respMap = new HashMap<String, String>();

	@Autowired
	MstResourceDesignationService resourceDesignationService;
	
	@SuppressWarnings("deprecation")
	@GetMapping
	@RequestMapping("list")
	public Iterable<MstResourceDesignation> list(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "size", required = false, defaultValue = "100") String size,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(value = "col", required = false, defaultValue = "resourceDesignationId") String col) {

		if (searchString == null || searchString.equals("") ) {
			return resourceDesignationService.findAllRecords(new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		} else {

			return resourceDesignationService.completeSearch(searchString, new PageRequest(Integer.parseInt(page) - 1,
					Integer.parseInt(size), Sort.Direction.fromString(sort), col));

		}

	}

}
