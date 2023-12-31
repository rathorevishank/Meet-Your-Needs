package com.example.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Vendor;
import com.example.demo.repositories.VendorRepository;
 
@Service
public class VendorService 
{
   @Autowired
   VendorRepository repo;
	
   public List<Vendor> getAll()
	{
		return repo.findAll();
	}
   public Vendor getById(int vid)
	{
		return  repo.getById(vid);
	}
   public Vendor getByUid(int uid)
   {
	   return repo.getByUserId(uid);
   }
   
}