package com.ecommerce.parameters;

import com.ecommerce.models.Business;

public class BusinessParameter {
	
	private String name;
	private String description;
	private UserParameter ownerUser;
	
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
	public UserParameter getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(UserParameter ownerUser) {
		this.ownerUser = ownerUser;
	}
	
	public Business toModel() {
		Business model = new Business();
		
		model.setName(this.name);
		model.setDescription(this.description);
		
		if(this.ownerUser != null)
			model.setOwnerUser(ownerUser.toModel());
				
		return model;
	}
}