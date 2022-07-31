package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Category;

public interface CategoryService {
	
	public Category create(Category model);
	
	public Category update(Category model);
	
	public Category findById(Long id);
	
	public List<Category> findAll();
	
	public boolean deleteById(Long id);
}
