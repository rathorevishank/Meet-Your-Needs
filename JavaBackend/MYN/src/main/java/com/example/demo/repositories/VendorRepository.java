package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Vendor;
@Repository
@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Integer> 
{
	 @Query("select v from Vendor v where vendor_id = ?1")
	 public Vendor getById(int vendor_id);
	 
	 @Query("select v from Vendor v where userid.userId = ?1")
	 public Vendor getByUserId(int vendor_id);
}
