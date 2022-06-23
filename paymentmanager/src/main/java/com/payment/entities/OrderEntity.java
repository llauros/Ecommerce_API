package com.payment.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecommerce.models.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lib.easymart.models.Order;

@Entity
@Table(name = "tb_pedido")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@Column(name = "data")
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private UserEntity userClient;
	
	@OneToMany(mappedBy = "id.order")
	@JsonIgnore
	private Set<OrderProductEntity> products;

	public OrderEntity() {}

	public OrderEntity(Order model) {
		if (model != null) 
			this.moment = model.getMoment(); 
			
		if (model.getUserClient() != null) 
			this.userClient = new UserEntity(model.getUserClient());
	}
	
	public OrderEntity(Instant moment, OrderStatus orderStatus, UserEntity userClient) {
		this.moment = moment;
		setOrderStatus(orderStatus);
		/*this.userClient = userClient;*/
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
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}		
	}
	public UserEntity getUserClient() {
		return userClient;
	}
	public void setUserClient(UserEntity userClient) {
		this.userClient = userClient;
	}
	public Set<OrderProductEntity> getProducts() {
		return products;
	}
	public void setProducts(Set<OrderProductEntity> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Order toModel() {
		Order model = new Order();
		
		model.setId(this.id);
		model.setMoment(this.moment);
		//model.setUserClient(this.userClient.toModel());
		//model.setOrderProducts(products.stream().map(a -> a.toModel()).collect(Collectors.toSet()));
		
		return model;
	}
}
