package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VendorFeedback;
import com.example.demo.services.VendorFeedbackService;

@RestController
public class VendorFeedbackController {
	
	@Autowired
	VendorFeedbackService service;
	
	@CrossOrigin
	@GetMapping("/getfeedback")
	public List<VendorFeedback> getall()
	{
		return service.getall();
	}
	
	@CrossOrigin
	@PostMapping("/sendfeedback")
	public VendorFeedback addFeedback(@RequestBody VendorFeedback feedback)
	{
		return service.add(feedback);
	}
}
