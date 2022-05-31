package com.ecommerce.models;

public class Business {
	
	private Long id;
	private String name;
	private String description;	
/*	private String profilePicture;
	private String bannerImage;
	private Date createdAt;
	private Date updatedAt;
*/
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
	
}
