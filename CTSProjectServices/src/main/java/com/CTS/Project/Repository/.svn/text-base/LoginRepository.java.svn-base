package com.CTS.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.User;


public interface LoginRepository extends JpaRepository<User, Long>{
	
	User findByUsernameAndPassword(String username,String Password);

}
