package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Question;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
