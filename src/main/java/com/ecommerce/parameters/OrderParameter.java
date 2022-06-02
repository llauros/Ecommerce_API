package com.ecommerce.parameters;

import java.time.Instant;

import com.ecommerce.models.Order;

public class OrderParameter {

	private Instant moment;
	private UserParameter userClient;
	
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public UserParameter getUserClient() {
		return userClient;
	}
	public void setUserClient(UserParameter userClient) {
		this.userClient = userClient;
	}
	
	public Order toModel() {
		Order model = new Order();
		
		model.setMoment(this.moment);
		model.setUserClient(this.userClient.toModel());
		
		return model;
	}
	
}
