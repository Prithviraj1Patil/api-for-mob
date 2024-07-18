package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.UserMasterService;
import com.app.dto.UserMasterDto;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserMasterController {
	@Autowired	
	private UserMasterService umService;

	@GetMapping("/")
	public ResponseEntity<List<UserMasterDto>> getAllUserMaster(){
		return  ResponseEntity.ok(this.umService.getAllUsers());
	}
}
