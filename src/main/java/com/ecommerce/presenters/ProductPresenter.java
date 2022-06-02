package com.ecommerce.presenters;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.ecommerce.models.Product;

public class ProductPresenter {
	
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private String photo;
	private BusinessPresenter business;
	private Set<SubCategoryPresenter> subCategories;
	
	public ProductPresenter(Product model) {
		this.id = model.getId();
		this.name = model.getName();
		this.description = model.getDescription();
		this.price = model.getPrice();
		this.photo = model.getPhoto();
		
		if(model.getBusiness() != null) 
			this.business = new BusinessPresenter(model.getBusiness());
		
		if(model.getSubCategories() != null) 
			this.subCategories = model.getSubCategories().stream().map(a -> new SubCategoryPresenter(a)).collect(Collectors.toSet());
	}
	
	public Long getId() {return id;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public BigDecimal getPrice() {return price;}
	public String getPhoto() {return photo;}
	public BusinessPresenter getBusiness() {return business;}
	public Set<SubCategoryPresenter> getSubCategories() {return subCategories;}
	
}
