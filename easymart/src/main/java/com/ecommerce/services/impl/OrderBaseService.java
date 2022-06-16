package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.OrderEntity;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.services.OrderService;

import lib.easymart.models.Order;

@Service
public class OrderBaseService implements OrderService{

	@Autowired
	private OrderRepository repository;

	@Override
	public List<Order> findAll() {
		List<OrderEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get();
		}
		return null;
	}
	
	@Override
	public Order create(Order model) {
		OrderEntity entity = repository.save(new OrderEntity(model));
		
		return entity.toModel();
	}

	@Override
	public Order update(Order model) {
			
		return repository.findById(model.getId()).map( result -> {
			
			result.setMoment(model.getMoment());;
			
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});
		
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<OrderEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}