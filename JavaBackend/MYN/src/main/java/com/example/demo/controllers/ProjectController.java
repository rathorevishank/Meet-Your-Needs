package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.services.ProjectService;

@RestController
@CrossOrigin
public class ProjectController {
	@Autowired
	ProjectService service;
	
	
	@GetMapping("/getProject")
	public List<Project> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping("/addProject")
	public Project addProj(@RequestBody Project project)
	{
		return service.add(project);
	}
	
	@GetMapping("/getProjById")
	public Project getbyid(@RequestParam("id") int id)
	{
		return service.getbyId(id);
	}
}
