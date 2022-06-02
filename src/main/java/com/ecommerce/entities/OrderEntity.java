package com.ecommerce.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecommerce.models.Order;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class OrderEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@Column(name = "data")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private UserEntity userClient;

	public OrderEntity() {}

	public OrderEntity(Order model) {
		if(model != null) 
			this.moment = model.getMoment(); 
			
		if (model.getUserClient() != null) 
			this.userClient = new UserEntity(model.getUserClient());
	}
	
	public OrderEntity(Instant moment, UserEntity userClient) {
		this.moment = moment;
		this.userClient = userClient;
	}

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
	public UserEntity getUserClient() {
		return userClient;
	}
	public void setUserClient(UserEntity userClient) {
		this.userClient = userClient;
	}
	
	public Order toModel() {
		Order model = new Order();
		
		model.setId(this.id);
		model.setMoment(this.moment);
		model.setUserClient(userClient.toModel());
		
		return model;
	}
	
}
