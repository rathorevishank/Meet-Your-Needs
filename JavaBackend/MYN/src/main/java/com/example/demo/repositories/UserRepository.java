package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
 @Query("select u from User u where email = ?1")
 public User getByEmail(String email);
 
 @Query("select u from User u where phone_no = ?1")
 public User getByContact(String phone_no);

 @Query("select u from User u where adhar_no = ?1")
 public User getByAadhar(String aadhar);
}
