package com.ecommerce.presenters;

import lib.easymart.models.Category;

public class CategoryPresenter {

	private Long id;
	private String name;
	
	public CategoryPresenter(Category model) {
		this.id = model.getId();
		this.name = model.getName();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
