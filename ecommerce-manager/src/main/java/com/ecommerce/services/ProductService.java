package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Product;

public interface ProductService {
	
	public Product create(Product model);
	
	public Product update(Product model);
	
	public Product findById(Long id);
	
	public List<Product> findAll();
 
	public boolean deleteById(Long id);
}
