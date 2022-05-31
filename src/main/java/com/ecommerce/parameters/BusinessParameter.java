package com.ecommerce.parameters;

import com.ecommerce.models.Business;

public class BusinessParameter {
	private String name;
	private String description;
	
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
	
	public Business toModel() {
		Business model = new Business();
		
		model.setName(this.name);
		model.setDescription(this.description);
		
		return model;
	}
}