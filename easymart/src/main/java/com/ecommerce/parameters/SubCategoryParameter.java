package com.ecommerce.parameters;

import lib.easymart.models.SubCategory;

public class SubCategoryParameter {

	private Long id;
	private String name;
	private CategoryParameter category;
	
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
	public CategoryParameter getCategory() {
		return category;
	}
	public void setCategory(CategoryParameter category) {
		this.category = category;
	}
	
	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setId(this.id);
		model.setName(this.name);
		
		if(this.category != null)
			model.setCategory(this.category.toModel());
		
		return model;
	}
}
