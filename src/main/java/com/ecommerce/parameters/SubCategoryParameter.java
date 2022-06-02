package com.ecommerce.parameters;

import com.ecommerce.models.SubCategory;

public class SubCategoryParameter {

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setName(this.name);
	
		return model;
	}
}
