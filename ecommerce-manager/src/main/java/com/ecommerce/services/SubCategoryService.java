package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.SubCategory;

public interface SubCategoryService {
	
	public SubCategory create(SubCategory model);
	
	public SubCategory update(SubCategory model);
	
	public SubCategory findById(Long id);
	
	public List<SubCategory> findAll();
    
	public boolean deleteById(Long id);
}
