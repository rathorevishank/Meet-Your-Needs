package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService 
{  @Autowired
   CategoryRepository repo;

public List<Category> getAll()
	{
		return repo.findAll();
	}
public Category getById(int cid)
	{
		return  repo.getById(cid);
	}
}
