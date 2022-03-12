package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

	// Find patient by their email
	@Query(value = "select * from category c where c.name = ?1", nativeQuery = true)
	public Category searchByName(String name);

	@Query(value = "select count(*) from category c where c.name = ?1", nativeQuery = true)
	public Integer countByName(String name);

}
