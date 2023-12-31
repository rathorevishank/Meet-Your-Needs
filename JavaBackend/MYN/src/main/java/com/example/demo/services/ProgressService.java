package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Progress;
import com.example.demo.repositories.ProgressRepository;
@Service
public class ProgressService {
	@Autowired
	ProgressRepository service;
	
	public List<Progress> getall()
	{
		return service.findAll();
	}
}
