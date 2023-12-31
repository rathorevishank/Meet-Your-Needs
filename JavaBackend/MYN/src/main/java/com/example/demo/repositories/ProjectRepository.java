package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
