package com.ecommerce.models;

import java.util.List;

public class Business {

	private Long id;
	private String name;
	private String description;
	private User ownerUser;
	private List<Product> products;

	/*
	 * private User ownerUser; //TODO Completar a Classe private String
	 * profilePicture; private String bannerImage; private Date createdAt; private
	 * Date updatedAt;
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
