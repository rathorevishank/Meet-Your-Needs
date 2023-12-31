package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Progress;
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Integer> {

}
