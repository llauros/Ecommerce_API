package com.ecommerce.models;

import java.time.Instant;

public class Order {

	private Long id;
	private Instant moment;
	private User userClient;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public User getUserClient() {
		return userClient;
	}
	public void setUserClient(User userClient) {
		this.userClient = userClient;
	}
		
}
