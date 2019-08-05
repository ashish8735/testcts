package com.CTS.Project.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	public static String getPasswordHash(String password) {
		return encoder.encode(password);
	}
	
	 public static boolean matches(CharSequence rawPassword, String encodedPassword) {
         return encoder.matches(rawPassword.toString(), encodedPassword);
     }

}
