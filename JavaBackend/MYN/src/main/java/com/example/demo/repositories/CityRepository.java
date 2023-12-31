package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.City;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer>{
	@Query("select c from City c where state_id=?1")
	public List<City> getByState(int state);
}
