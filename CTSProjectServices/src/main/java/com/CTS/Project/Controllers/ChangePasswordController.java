package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Services.ChangePasswordService;

@RestController
@RequestMapping("/changePassword")
public class ChangePasswordController {

	@Autowired
	ChangePasswordService changePasswordService;
	

	Map<String, String> respMap = new HashMap<String, String>();
	
	@GetMapping
	@RequestMapping("sendPassword")
	public Map<String, String> sendPassword(@RequestParam(value = "emailId") String emailId) {

		if(changePasswordService.sendPasswordURL(emailId).equals("success")) {
			respMap.put("success", "1");
			respMap.put("msg", "Process Completed Successfully");
			return respMap;
		}else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}
	
	@GetMapping
	@RequestMapping("varifyUser")
	public Boolean varifyUser(@RequestParam(value = "refToken") String refToken) {
		return changePasswordService.verifyUserByRefeshToken(refToken);
	}
	
	@GetMapping
	@RequestMapping("resetPassword")
	public Map<String, String> resetPassword(@RequestParam(value = "password") String password,@RequestParam(value = "refToken") String refToken) {

		if(changePasswordService.changePassword(password,refToken)) {
			respMap.put("success", "1");
			respMap.put("msg", "Passwod reset successfully.");
			return respMap;
		}else {
			respMap.put("success", "0");
			respMap.put("msg", "Fail to reset password.");
			return respMap;
		}
	}
	
	@GetMapping
	@RequestMapping("checkMail")
	public Boolean checkMail(@RequestParam(value = "emailId") String emailId) {
		return changePasswordService.emailAvailabilityCheck(emailId);
	}
	
	
}
