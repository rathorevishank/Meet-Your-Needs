package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Request;
@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Integer> {

	@Query("select r from Request r where status = 0")
	public List<Request> getPendingRequest();
	
	@Query("select r from Request r where status = 0 and client.clientId = ?1")
	public List<Request> getUserPendingRequest(int id);
}
