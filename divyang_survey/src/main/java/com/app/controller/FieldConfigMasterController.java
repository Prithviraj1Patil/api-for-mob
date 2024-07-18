package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.FieldConfigMasterService;
import com.app.dto.FieldConfigMasterDto;

@RestController
@RequestMapping("api/fcm")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FieldConfigMasterController {
	@Autowired
	private FieldConfigMasterService fcmService;

	@GetMapping("/")
	public ResponseEntity<List<FieldConfigMasterDto>> getAllFcm(){
		return ResponseEntity.ok(fcmService.findAllFieldConfigs());
	}
	
	@GetMapping("/qsns")
	public ResponseEntity<List<Object[]>> getAllQuestions(){
		return ResponseEntity.ok(fcmService.findAllFields());
	}
}
