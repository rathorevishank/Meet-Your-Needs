package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> 
{
	 @Query("select c from Category c where category_id = ?1")
	 public Category getById(int category_id);
}
