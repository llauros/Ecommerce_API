package com.payment.services;

import java.util.List;

import com.ecommerce.entities.OrderEntity;

import lib.easymart.models.Order;

public interface OrderService {
	
	public List<Order> findAll();
	
	public OrderEntity findById(Long id);
	
	public Order create(Order model);
	
	public Order update(Order model);
	
	public boolean deleteById(Long id);
    
}
