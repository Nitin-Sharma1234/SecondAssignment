
package com.example.demo.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;

@org.springframework.stereotype.Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	// Add new Category checking new Category on the basis of their Id
	public String addCategory(Category category) {
		try {
			// if the Category is already present inside database then return Category already exists
			if (!categoryDao.findById(category.getId()).isEmpty()) {
				return "Category already exists";
			}
				categoryDao.save(category);
				return "Category Successfully Added";
				
		} catch (Exception e) {
			System.out.println(e);
			return "Failed Something Went Wrong";
		}
	}
	// Update the Category check Category on the basis of their Id because id is unique.
	public String updateCategory(Category category) {
		try {
			// First check if the Category is present in the database or it's a new Category
			// If the Category is new then return Category doesn't exists
			if (categoryDao.findById(category.getId()).isEmpty()) {
				return "Category Doesn't Exists";
			}
			// if Category is present then i update the Category on the basis of It's id .

			categoryDao.save(category);
			return "Category Successfully Updated";

		} catch (Exception e) {
			System.out.println(e);
			return "Failed to update";
		}
	}


	// Show list of all the Category
	public List<Category> showAll() {
		return categoryDao.findAll();
	}

}
