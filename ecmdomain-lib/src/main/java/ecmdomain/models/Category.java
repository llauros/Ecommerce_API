package ecmdomain.models;

import java.util.Set;

public class Category {
	
	private Long id;
	private String name;
	private Set<SubCategory> subCategories;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Set<SubCategory> getSubCategories() {return subCategories;}
	public void setSubCategories(Set<SubCategory> subCategories) {this.subCategories = subCategories;}
	
	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}
	
}