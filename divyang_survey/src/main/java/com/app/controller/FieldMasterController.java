package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.FieldMasterService;
import com.app.dto.FieldMasterDto;

@RestController
@RequestMapping("/api/fieldMaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FieldMasterController {
	
	@Autowired
	private FieldMasterService fmService;
	
	@GetMapping("/")
	public ResponseEntity<List<FieldMasterDto>> findAllFieldMasters(){
		return ResponseEntity.ok(this.fmService.getAllFieldMasters());
	}

}
