package com.ecommerce.parameters;

import lib.easymart.models.Business;

public class BusinessParameter {
	
	private Long id;
	private String name;
	private String description;
	private UserParameter ownerUser;
	
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
		
		model.setId(this.id);
		model.setName(this.name);
		model.setDescription(this.description);
		
		/*if(this.ownerUser != null)
			model.setOwnerUser(this.ownerUser.toModel());*/
				
		return model;
	}
}