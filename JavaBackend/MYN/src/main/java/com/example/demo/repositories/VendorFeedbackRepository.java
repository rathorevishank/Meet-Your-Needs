package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorFeedback;

@Repository
@Transactional
public interface VendorFeedbackRepository extends JpaRepository<VendorFeedback, Integer> {

}
