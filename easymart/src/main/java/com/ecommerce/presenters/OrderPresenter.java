package com.ecommerce.presenters;

import java.time.Instant;
import java.util.Set;

import lib.easymart.models.Order;

public class OrderPresenter {

	private Long id;
	private Instant moment;
	private UserPresenter userClient;
	private Set<OrderProductPresenter> products;
	
	public OrderPresenter(Order model) {
		this.id = model.getId();
		this.moment = model.getMoment();
		this.userClient = new UserPresenter(model.getUserClient());
	}
	
	public Long getId() {
		return id;
	}
	public Instant getMoment() {
		return moment;
	}
	public UserPresenter getUserClient() {
		return userClient;
	}
	public Set<OrderProductPresenter> getProducts() {
		return products;
	}
	
	
	
}
