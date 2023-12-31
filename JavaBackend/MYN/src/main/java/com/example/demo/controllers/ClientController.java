package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.services.ClientService;

@RestController
public class ClientController {
	@Autowired
	ClientService service;
	
	@CrossOrigin
	@GetMapping("/getUser")
	public Client getbyUser(@RequestParam("id") int id)
	{
		return service.getByUser(id);
	}
	
	@CrossOrigin
	@PostMapping("/addClient")
	public Client adduser(@RequestBody Client client)
	{
		return service.add(client);
	}
}
