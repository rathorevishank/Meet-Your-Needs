package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VendorPortfolio;
import com.example.demo.services.VendorPortfolioService;
@RestController
public class VendorPortfolioController
{

	@Autowired
	VendorPortfolioService service;
	@CrossOrigin
	@GetMapping("/allVendorPortfolio")
	public List<VendorPortfolio> getall()
	{
		return service.getAll();
	}
	@CrossOrigin
	@GetMapping("/getVendorPortfolioByid")
	public VendorPortfolio getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
	
	@CrossOrigin
	@GetMapping("/getVendorPortfolioByVendor")
	public VendorPortfolio getByVendor(@RequestParam ("id") int id)
	{
		return service.getByVendor(id);
	}

}
