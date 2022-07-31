package com.ecommerce.presenters;

import com.ecommerce.models.SubCategory;

public class SubCategoryPresenter {

	private Long id;
	private String name;
	
	public SubCategoryPresenter(SubCategory model) {
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
