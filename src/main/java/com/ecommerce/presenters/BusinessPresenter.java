package com.ecommerce.presenters;

import com.ecommerce.models.Business;

public class BusinessPresenter {

	private Long id;
	private String name;
	private String description;
	
	public BusinessPresenter(Business model) {
		if(model != null) {
			this.id = model.getId();
			this.name = model.getName();
			this.description = model.getDescription();
		}
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
	
}
