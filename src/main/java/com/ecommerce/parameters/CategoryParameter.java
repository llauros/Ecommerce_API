package com.ecommerce.parameters;

import com.ecommerce.models.Category;

public class CategoryParameter {

	private String name;
	
	public CategoryParameter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public Category toModel() {
		Category model = new Category();
		
		model.setName(this.name);
	
		return model;
	}
}
