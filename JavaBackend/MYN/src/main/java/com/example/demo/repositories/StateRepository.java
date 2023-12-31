package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.State;

@Repository
@Transactional
public interface StateRepository extends JpaRepository<State, Integer> {

}
