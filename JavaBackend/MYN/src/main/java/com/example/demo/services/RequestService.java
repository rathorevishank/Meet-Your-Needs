package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Request;
import com.example.demo.entity.User;
import com.example.demo.repositories.RequestRepository;
@Service
public class RequestService 
{
	@Autowired
	RequestRepository repo;
	
	public List<Request> getall()
	{
		return repo.findAll();
	}
	
	public Request addReq(Request req)
	{
		return repo.save(req);
	}
	
	public Request getReq(int id)
	{
		Optional<Request> stud = repo.findById(id);
		Request user = null;
		try
		{
			user=stud.get();
		}
		catch(NoSuchElementException e)
		{
			user = null;
		}
		return user;
	}
	
	public List<Request> pendingReq()
	{
		return repo.getPendingRequest();
	}
	
	public List<Request> getUserReq(int id)
	{
		return repo.getUserPendingRequest(id);
	}
	
}
