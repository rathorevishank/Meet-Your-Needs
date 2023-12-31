package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Request;
import com.example.demo.entity.User;
import com.example.demo.services.RequestService;

@RestController
public class RequestController {
	@Autowired
	RequestService service;
	
	@CrossOrigin
	@GetMapping("/allRequest")
	public List<Request> getall()
	{
		return service.getall();
	}
	
	@CrossOrigin
	@PostMapping("/addReq")
	public Request addRequest(@RequestBody Request req)
	{
		System.out.println(req);
		return service.addReq(req);
	}
	
	@CrossOrigin
	@GetMapping("/getReqById")
	public Request getRequest(@RequestParam("id") int req)
	{
		return service.getReq(req);
	}
	
	@CrossOrigin
	@GetMapping("/pendingRequest")
	public List<Request> getpending()
	{
		return service.pendingReq();
	}
	
	@CrossOrigin
	@GetMapping("/pendingUserRequest")
	public List<Request> getUserpending(@RequestParam("id") int id)
	{
		return service.getUserReq(id);
	}
	
	@CrossOrigin
	@GetMapping("/updateReqStatus")
	public Request updateStatus(@RequestParam("id") int id)
	{
		Request req = getRequest(id);
		req.setStatus(1);
		return service.addReq(req);
	}
	
	
}
