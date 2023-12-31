package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository repo;
	
	public List<Role> getAll()
	{
		return repo.findAll();
	}
}
