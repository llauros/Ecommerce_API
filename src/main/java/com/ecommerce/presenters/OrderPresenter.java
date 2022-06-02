package com.ecommerce.presenters;

import java.time.Instant;

import com.ecommerce.models.Order;

public class OrderPresenter {

	private Long id;
	private Instant moment;
	private UserPresenter userClient;
	
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
	
	
	
}
