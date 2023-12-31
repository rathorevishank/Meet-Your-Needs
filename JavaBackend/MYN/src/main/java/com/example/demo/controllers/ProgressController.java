package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Progress;

import com.example.demo.services.ProgressService;
@RestController

public class ProgressController 
{
	@Autowired
	ProgressService service;
	
	@CrossOrigin
	@GetMapping("/allProgress")
	public List<Progress> getall()
	{
		return service.getall();
	}
	
	

}
