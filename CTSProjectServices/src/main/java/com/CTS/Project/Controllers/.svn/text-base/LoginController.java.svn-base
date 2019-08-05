package com.CTS.Project.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.Project.Models.User;
import com.CTS.Project.Services.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	Map<String, Object> respMap = new HashMap<String, Object>();

	@RequestMapping(value = "/login")
	public Map<String, Object> getUsers(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		User objUser = loginService.findUserById(username, password);
		if (objUser != null) {
			respMap.put("user", objUser);
			respMap.put("success", "1");
			respMap.put("msg", "Login Successfully");
			return respMap;
		} else {
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Login");
			return respMap;
		}
	}
}
