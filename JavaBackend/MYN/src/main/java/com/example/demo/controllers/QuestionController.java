package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.services.QuestionService;
@RestController
public class QuestionController {
	@Autowired
	QuestionService service;
	
	@CrossOrigin
	@GetMapping("/allQuestions")
	public List<Question> getall()
	{
		return service.getall();
	}
}
