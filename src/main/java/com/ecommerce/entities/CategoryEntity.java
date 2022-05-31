package com.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecommerce.models.Category;

@Entity
@Table(name = "tb_categoria")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String name;
	
	public CategoryEntity() {}
	
	public CategoryEntity (Category model) {
		this.id = model.getId();
		this.name = model.getName();
	}
	
	public CategoryEntity (String name) {
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

	public Category toModel() {
		Category model = new Category();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	} 

}
