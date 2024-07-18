package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.SystemConfigurationService;
import com.app.dto.SystemConfigurationDto;

@RestController
@RequestMapping("/api/sc")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SystemConfigurationController {
	
	@Autowired
	private SystemConfigurationService scService;
	
	@GetMapping("/")
	public ResponseEntity<List<SystemConfigurationDto>> getAllSc(){
		return ResponseEntity.ok(scService.findAllSc());
	}

}
