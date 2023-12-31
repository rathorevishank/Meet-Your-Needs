package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Skill;
import com.example.demo.repositories.SkillRepository;
@Service
public class SkillService
{
	@Autowired
	   SkillRepository repo;

	public List<Skill> getAll()
		{
			return repo.findAll();
		}
	public Skill getById(int sid)
		{
			return  repo.getById(sid);
		}

}
