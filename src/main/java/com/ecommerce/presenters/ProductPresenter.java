package com.ecommerce.presenters;

import java.math.BigDecimal;

import com.ecommerce.models.Product;

public class ProductPresenter {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private String photo;
	
	public ProductPresenter(Product model) {
		this.id = model.getId();
		this.name = model.getName();
		this.description = model.getDescription();
		this.price = model.getPrice();
		this.photo = model.getPhoto();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getPhoto() {
		return photo;
	}
	
}
