package com.CTS.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CtsProjectServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtsProjectServicesApplication.class, args);
	}

}
