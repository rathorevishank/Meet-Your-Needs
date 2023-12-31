package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Response;
@Repository
@Transactional
public interface ResponseRepository extends JpaRepository<Response, Integer> 
{
	@Query("select r from Response r where response_id = ?1")
	 public Response getById(int response_id);
	
	@Query("select r from Response r where request_id = ?1")
	public List<Response> getByRequest(int id);
}
