package com.CTS.Project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.CTS.Project.Services.AppUserDetailsService;


@Component
public class CustomAuthenticationProvider implements AuthenticationManager {

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Override
	 public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	          String username = authentication.getName();
	          String password = (String) authentication.getCredentials();
	     
	            UserDetails user = appUserDetailsService.loadUserByUsername(username);
	     
	            if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
	                throw new BadCredentialsException("Username not found.");
	            }
	     
	            if (!PasswordUtil.matches(password, user.getPassword())) {
	                throw new BadCredentialsException("Wrong password.");
	            }
	     
	          //  Collection<? extends GrantedAuthority> authorities =user.getAuthorities();
	            return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
	    }
	 
	    public boolean supports(Class<?> arg0) {
	        return true;
	    }
}
