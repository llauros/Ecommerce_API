package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Order;

public interface OrderService {
	
	public List<Order> findAll();
	
	public Order findById(Long id);
	
	public Order create(Order model);
	
	public Order update(Order model);
	
	public boolean deleteById(Long id);
    
}
