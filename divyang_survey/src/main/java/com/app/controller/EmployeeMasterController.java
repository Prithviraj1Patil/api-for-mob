package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.EmployeeMasterService;
import com.app.dto.EmployeeMasterDto;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeMasterController {
	
	@Autowired
	private EmployeeMasterService emService;
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeMasterDto>> getAllEmp(){
		return ResponseEntity.ok(this.emService.getAllEmployee());
	}

}
