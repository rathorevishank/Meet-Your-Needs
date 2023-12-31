package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	CityRepository repository;
	
	public List<City> getAll()
	{
		return repository.findAll();
	}
	
	public List<City> getByState(int state)
	{
		return repository.getByState(state);
	}
}
