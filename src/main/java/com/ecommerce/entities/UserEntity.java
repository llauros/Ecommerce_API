package com.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecommerce.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String password;
	
	@OneToOne(mappedBy = "ownerUser", cascade = CascadeType.ALL)
	private BusinessEntity business;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userClient", cascade = CascadeType.ALL)
	private List<OrderEntity> orders;/* = new ArrayList<>();*/
	
	public UserEntity() {}

	public UserEntity(User model) {
		this.name = model.getName();
		this.email = model.getEmail();
		this.password = model.getPassword();
	}

	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserEntity(String name, String email, String password, List<OrderEntity> orders) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() { return id;}
	public void setId(Long id) { this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public BusinessEntity getBusiness() {return business;}
	public void setBusiness(BusinessEntity business) {this.business = business;}
	
	public List<OrderEntity> getOrders() {return orders;}
	public void setOrders(List<OrderEntity> orders) {this.orders = orders;}

	public User toModel() {
		User model = new User();

		model.setId(this.id);
		model.setName(this.name);
		model.setEmail(this.email);
		model.setPassword(this.password);
		
		
		return model;
	}
}
