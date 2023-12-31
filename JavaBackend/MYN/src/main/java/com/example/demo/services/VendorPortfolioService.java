package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.VendorPortfolio;
import com.example.demo.repositories.VendorPortfolioRepository;

@Service
public class VendorPortfolioService 
{
	@Autowired
	   VendorPortfolioRepository repo;
		
	   public List<VendorPortfolio> getAll()
		{
			return repo.findAll();
		}
	   public VendorPortfolio getById(int vid)
		{
			return  repo.getById(vid);
		}
	   
	   public VendorPortfolio getByVendor(int vid)
		{
			return  repo.getByVendor(vid);
		}
	   
	   
}
