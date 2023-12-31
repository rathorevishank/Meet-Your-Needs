package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository service;
	
	public List<Question> getall()
	{
		return service.findAll();
	}
}
