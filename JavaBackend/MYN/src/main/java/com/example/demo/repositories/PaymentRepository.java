package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
	@Query("select p from Payment p where payment_id = ?1")
	 public Payment getById(int payment_id);

}
