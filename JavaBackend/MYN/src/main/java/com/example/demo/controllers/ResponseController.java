package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Response;
import com.example.demo.services.ResponseService;

@RestController
public class ResponseController
{
	@Autowired
	ResponseService service;
	
	@CrossOrigin
	@GetMapping("/allResponse")
	public List<Response> getall()
	{
		return service.getall();
	}
	@CrossOrigin
	@GetMapping("/getByResponseid")
	public Response getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
	
	@CrossOrigin
	@PostMapping("/addResp")
	public Response addResp(@RequestBody Response res)
	{
		return service.addResp(res);
	}
	
	@CrossOrigin
	@GetMapping("/getResByReq")
	public List<Response> getByReq(@RequestParam("id") int id)
	{
		return service.getByReq(id);
	}
}
