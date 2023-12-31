package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vendor;
import com.example.demo.services.VendorService;
@RestController
public class VendorController
{
	@Autowired
	VendorService service;
	@CrossOrigin
	@GetMapping("/allVendor")
	public List<Vendor> getall()
	{
		return service.getAll();
	}
	@CrossOrigin
	@GetMapping("/getVendorByid")
	public Vendor getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
	@CrossOrigin
	@GetMapping("/getVendorByUser")
	public Vendor getByUId(@RequestParam ("id") int id)
	{
		return service.getByUid(id);
	}
	

}
