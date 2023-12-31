package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VendorFeedback;
import com.example.demo.repositories.VendorFeedbackRepository;

@Service
public class VendorFeedbackService {
	
	@Autowired
	VendorFeedbackRepository repo;
	
	public List<VendorFeedback> getall()
	{
		return repo.findAll();
	}
	
	public VendorFeedback add(VendorFeedback feedback)
	{
		return repo.save(feedback);
	}
}
