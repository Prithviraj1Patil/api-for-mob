package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.Entity.UserMaster;
import com.app.Repository.UserMasterRepo;
import com.app.exception.ResourceNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMasterRepo usmRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UserMaster user=usmRepo.findByUsmUserName(username).orElseThrow(()-> new ResourceNotFoundException("UserMaster ", "user name : "+username, 0));
		return user;
	}

}
