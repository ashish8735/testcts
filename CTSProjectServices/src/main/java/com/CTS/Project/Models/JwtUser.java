package com.CTS.Project.Models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final Long id;
	private final String username;
	private final String firstname;
	private final String lastname;
	private final String password;
	private final Collection<? extends GrantedAuthority> roles;
	private final Collection<?> other;

	public JwtUser(Long id, String username, String firstname, String lastname, String password,
			Collection<? extends GrantedAuthority> roles, Collection<?> other) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.roles = roles;
		this.other = other;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Collection<?> getOther() {
		return other;
	}

}
