package com.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecommerce.models.Category;
import com.ecommerce.models.SubCategory;

@Entity
@Table(name = "tb_subcategoria")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String name;
	
	public SubCategoryEntity() {}
	
	public SubCategoryEntity (SubCategory model) {
		this.id = model.getId();
		this.name = model.getName();
	}	
	
	public SubCategoryEntity (String name, Category model) {
		this.name = name;
	}
	
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

	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	}
	
}