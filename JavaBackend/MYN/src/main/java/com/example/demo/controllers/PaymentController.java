package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Vendor;
import com.example.demo.services.PaymentService;

@RestController
public class PaymentController 
{
	
	@Autowired
	PaymentService service;
	
	@CrossOrigin
	@GetMapping("/allPayment")
	public List<Payment> getAll()
	{
		return service.getAll();
	}
	@GetMapping("/getPaymentByid")
	public Payment getById(@RequestParam ("id") int id)
	{
		return service.getById(id);
	}
	
	@CrossOrigin
	@PostMapping("/addPayment")
	public Payment add(@RequestBody Payment pay)
	{
		return service.add(pay);
	}
}
