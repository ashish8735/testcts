package com.CTS.Project.ServiceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.User;
import com.CTS.Project.Repository.LoginRepository;
import com.CTS.Project.Services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public User findUserById(String username, String password) {
		return loginRepository.findByUsernameAndPassword(username, password);
	}

}
