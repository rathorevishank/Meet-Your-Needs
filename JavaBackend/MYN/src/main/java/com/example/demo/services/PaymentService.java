package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;

import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository repo;

	public List<Payment> getAll() {
		return repo.findAll();
	}

	public Payment getById(int pid) {
		return repo.getById(pid);
	}
	
	public Payment add(Payment pay)
	{
		return repo.save(pay);
	}

}
