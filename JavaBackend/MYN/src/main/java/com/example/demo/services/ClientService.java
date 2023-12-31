package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository repo;
	
	public Client getByUser(int id)
	{
		return repo.getByUserID(id);
	}
	
	public Client add(Client client)
	{
		return repo.save(client);
	}
}
