package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Integer> {
	@Query("select c from Client c where c.clientId = ?1")
	public Client getByUserID(int uid);
}
