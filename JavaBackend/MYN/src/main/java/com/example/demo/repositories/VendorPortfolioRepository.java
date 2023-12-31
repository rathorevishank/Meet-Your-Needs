package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorPortfolio;
@Repository
@Transactional
public interface VendorPortfolioRepository extends JpaRepository<VendorPortfolio, Integer> 
{
	 @Query("select v from VendorPortfolio v where portfolio_id = ?1")
	 public VendorPortfolio getById(int portfolio_id);
	 
	 @Query("select v from VendorPortfolio v where v_id.vendorid = ?1")
	 public VendorPortfolio getByVendor(int portfolio_id);

}
