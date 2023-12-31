package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Skill;
import com.example.demo.services.SkillService;
@RestController
public class SkillController 
{
	@Autowired
	SkillService service;
	@CrossOrigin
	@GetMapping("/allSkill")
	public List<Skill> getall()
	{
		return service.getAll();
	}
	@CrossOrigin
	@GetMapping("/getBySkillid")
	public Skill getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
}
