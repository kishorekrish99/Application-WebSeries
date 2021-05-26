package com.examly.springapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.Model.webseries;

@Repository
public interface AppDAO extends JpaRepository<webseries, Integer> {
	
	@Query(value = "SELECT * FROM webseries WHERE name = ?1", nativeQuery = true)
	public List<webseries> findbyname(String name);

}
