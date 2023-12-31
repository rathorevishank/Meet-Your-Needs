package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.State;
import com.example.demo.services.StateService;

@RestController
public class StateController {
	@Autowired
	StateService service;
	
	@CrossOrigin
	@GetMapping("/allState")
	public List<State> getall()
	{
		return service.getAll();
	}
}
