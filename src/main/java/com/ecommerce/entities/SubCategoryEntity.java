package com.ecommerce.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecommerce.models.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_subcategoria")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoryEntity category;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subCategories")
	private Set<ProductEntity> products = new HashSet<>(); 
	
	public SubCategoryEntity() {}
	
	public SubCategoryEntity (SubCategory model) {
		this.name = model.getName();
		
		if(model.getCategory() != null)
			this.category = new CategoryEntity(model.getCategory());
	}	
	
	public SubCategoryEntity (String name, CategoryEntity category) {
		this.name = name;
		this.category = category;
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
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public Set<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	}
	
}