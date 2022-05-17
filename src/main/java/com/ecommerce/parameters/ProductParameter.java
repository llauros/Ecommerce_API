package com.ecommerce.parameters;

import java.math.BigDecimal;

import com.ecommerce.models.Product;

public class ProductParameter {
	private String name;
	private String description;
	private BigDecimal price;
	private String photo;
	
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Product toModel() {
		Product model = new Product();
		
		model.setName(this.name);
		model.setDescription(this.description);
		model.setPrice(this.price);
		model.setPhoto(this.photo);
		
		return model;
	}
}