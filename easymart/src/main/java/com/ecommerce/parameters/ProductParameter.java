package com.ecommerce.parameters;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import lib.easymart.models.Product;

public class ProductParameter {
	
	private String name;
	private String description;
	private BigDecimal price;
	private String photo;
	private BusinessParameter business;
	private Set<SubCategoryParameter> subCategories;
	
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
	public BusinessParameter getBusiness() {
		return business;
	}
	public void setBusiness(BusinessParameter business) {
		this.business = business;
	}
	public Set<SubCategoryParameter> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<SubCategoryParameter> subCategories) {
		this.subCategories = subCategories;
	}
	
	public Product toModel() {
		Product model = new Product();
		
		model.setName(this.name);
		model.setDescription(this.description);
		model.setPrice(this.price);
		model.setPhoto(this.photo);
		
		if(this.business != null) 
			model.setBusiness(this.business.toModel());
		
		if(this.subCategories != null) 
			model.setSubCategories(this.subCategories.stream().map(a -> a.toModel()).collect(Collectors.toSet()));
		

		return model;
	}
}