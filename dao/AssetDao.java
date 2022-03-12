package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Asset;

public interface AssetDao extends JpaRepository<Asset, String> {

	@Query(value="select * from asset a where a.name = ?1" , nativeQuery = true)
	public Asset searchByName(String name);
}
