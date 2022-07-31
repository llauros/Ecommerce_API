package com.ecommerce.presenters;

import com.ecommerce.models.Business;

public class BusinessPresenter {

	private Long id;
	private String name;
	private String description;
	private UserPresenter ownerUser;
	
	public BusinessPresenter(Business result) {
		if(result != null) {
			this.id = result.getId();
			this.name = result.getName();
			this.description = result.getDescription();
			
			if(result.getOwnerUser() != null)
				this.ownerUser = new UserPresenter(result.getOwnerUser());
			
		}
	}

	public Long getId() {return id;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public UserPresenter getOwnerUser() {return ownerUser;}
	
}
