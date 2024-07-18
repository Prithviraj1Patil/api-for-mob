package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JwtAuthRequest;
import com.app.dto.JwtAuthResponse;
import com.app.security.JwtTokenHelper;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwttokenHelper;
	@Autowired
	private UserDetailsService userDetailsservice;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails =this.userDetailsservice.loadUserByUsername(request.getUsername());
		String token=this.jwttokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}

	private void authenticate(String userName, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userName,password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			System.out.println("Invalid Details !!"  + e.getMessage());
			throw new Exception("Invalid username or password!");
		}
	
		
	}

}
