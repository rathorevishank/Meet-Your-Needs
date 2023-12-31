package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.State;
import com.example.demo.repositories.StateRepository;

@Service
public class StateService {
	@Autowired
	StateRepository repository;
	
	public List<State> getAll()
	{
		return repository.findAll();
	}
}
