package com.payment.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entities.OrderEntity;
import com.payment.parameters.OrderParameter;
import com.payment.presenters.OrderPresenter;
import com.payment.services.OrderService;

import lib.easymart.models.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderPresenter>> findAll() {
		List<Order> result = this.service.findAll();

		if (result != null) {		
			return new ResponseEntity(result.stream().map(a -> new OrderPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderEntity> findById(@PathVariable Long id) {
		OrderEntity result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(result, HttpStatus.OK);	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@PostMapping
	public ResponseEntity<OrderPresenter> create(@RequestBody OrderParameter parameter) {
		
		if (parameter != null) {
			Order model = parameter.toModel();

			return new ResponseEntity(new OrderPresenter(this.service.create(model)), HttpStatus.CREATED);	
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderPresenter> update(@PathVariable Long id, @RequestBody OrderParameter parameter) {
		
		if (parameter != null) {
			Order user = parameter.toModel();
			user.setId(id);
			
			Order result = this.service.update(user);
			
			if(result != null) {				
				return new ResponseEntity(new OrderPresenter(result), HttpStatus.CREATED);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);	
			}	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		boolean result = this.service.deleteById(id);

		if (result) {
			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}