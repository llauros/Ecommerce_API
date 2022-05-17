package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product create(Product model);
	
	public Product update(Product model);
	
	public boolean deleteById(Long id);
    
}
