package com.ecommerce.presenters;

import com.ecommerce.models.Business;

public class BusinessPresenter {

	private Long id;
	private String name;
	private String description;
	private UserPresenter ownerUser;
	
	public BusinessPresenter(Business model) {
		if(model != null) {
			this.id = model.getId();
			this.name = model.getName();
			this.description = model.getDescription();
			if(model.getOwnerUser() != null) {
				this.ownerUser = new UserPresenter(model.getOwnerUser());
			}
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
	public UserPresenter getOwnerUser() {
		return ownerUser;
	}
	
	
}
