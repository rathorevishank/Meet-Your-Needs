package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@CrossOrigin
	@GetMapping("/allUsers")
	public List<User> getall()
	{
		return service.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/getbyid")
	public User getById(@RequestParam("id") int id)
	{
		return service.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("/getbyemail")
	public User getByemail(@RequestParam("email") String email)
	{
		User user = service.getByMail(email);
		if(user == null)
		{
			user = new User();
		}
		return user;
	}
	
	@CrossOrigin
	@GetMapping("/getbycontact")
	public User getBycontact(@RequestParam("phone_no") String phone_no)
	{
		return service.getByContact(phone_no);
	}
	
	@CrossOrigin
	@GetMapping("/getbyaadhar")
	public User getByAadhar(@RequestParam("aadhar") String aadhar)
	{
		return service.getByAadhar(aadhar);
	}
	
	@CrossOrigin
	@GetMapping("/checkuser")
	public User checkValidate(@RequestParam("mail") String email,@RequestParam("password") String password)
	{
		User user = service.getByMail(email);
		//System.out.println(user);
		System.out.println(password + " "+user.getPassword());
		if(!user.getPassword().equals(password))
		{
			user = new User();
		}
		//System.out.println(user);
		return user;
	}
	
	@CrossOrigin
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}
}
