package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Skill;
@Repository
@Transactional
public interface SkillRepository extends JpaRepository<Skill, Integer> 
{

	 @Query("select s from Skill s where skill_id = ?1")
	 public Skill getById(int skill_id);
}
