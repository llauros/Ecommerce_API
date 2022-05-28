package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.SubCategory;

public interface SubCategoryService {
	
	public List<SubCategory> findAll();
	
	public SubCategory findById(Long id);
	
	public SubCategory create(SubCategory model);
	
	public SubCategory update(SubCategory model);
	
	public boolean deleteById(Long id);
    
}
