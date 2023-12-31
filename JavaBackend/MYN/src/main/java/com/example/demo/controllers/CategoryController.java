package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Category;
import com.example.demo.services.CategoryService;
@RestController
public class CategoryController {
	@Autowired
	CategoryService service;
	
	@CrossOrigin
	@GetMapping("/allCategory")
	public List<Category> getall()
	{
		return service.getAll();
	}
	@CrossOrigin
	@GetMapping("/getByCategoryid")
	public Category getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
}
