package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public List<User> getAll()
	{
		return repository.findAll();
	}
	
	public User getOne(int id)
	{
		Optional<User> stud = repository.findById(id);
		User user = null;
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
	
	public User getByMail(String email)
	{
		Optional<User> stud = Optional.ofNullable(repository.getByEmail(email));
		User user = null;
		try
		{
			user=stud.get();
		}
		catch(NoSuchElementException e)
		{
			user = null;
		}
		//System.out.println(user);
		return user;
	}
	
	public User getByContact(String phone_no)
	{
		return  repository.getByContact(phone_no);
	}
	
	public User getByAadhar(String aadhar)
	{
		return  repository.getByAadhar(aadhar);
	}
	
	public User addUser(User user)
	{
		return repository.save(user);
	}
}
