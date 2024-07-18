package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.QuestionService;
import com.app.dto.QuestionDto;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {

	@Autowired
	private QuestionService qService;
	
	@GetMapping("/")
	public ResponseEntity<List<QuestionDto>> getAllQsns(){
		return ResponseEntity.ok(this.qService.getAllQuestions());
	}
	
}
