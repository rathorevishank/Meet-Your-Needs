package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.City;
import com.example.demo.services.CityService;

@RestController
public class CityController {
	@Autowired
	CityService service;
	
	@CrossOrigin
	@GetMapping("/allCity")
	public List<City> getall()
	{
		return service.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/getcitybystate")
	public List<City> getByState(int state)
	{
		return service.getByState(state);
	}
}
