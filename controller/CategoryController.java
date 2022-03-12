package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService service;

	// For Adding new Category .
	@PostMapping("/add")
	public String addCategory(@RequestBody Category category) {

		return service.addCategory(category);

	}

	// For getting all the list of Category.
	@GetMapping("/showall")
	public List<Category> showAll() {

		return service.showAll();

	}

	// Update the Category .
	@PostMapping("/update")
	public String updateCategory(@RequestBody Category patient) {

		return service.updateCategory(patient);

	}

}
