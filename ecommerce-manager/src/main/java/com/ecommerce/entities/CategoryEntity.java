package com.ecommerce.entities;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<SubCategoryEntity> subCategories = new HashSet<>();

	public CategoryEntity() {}

	public CategoryEntity(Category model) {

		this.id = model.getId();
		this.name = model.getName();

		if (model.getSubCategories() != null)
			this.subCategories = model.getSubCategories().stream().map(a -> new SubCategoryEntity(a)).collect(toSet());
	}

	public CategoryEntity(String name) {
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

	public Set<SubCategoryEntity> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategoryEntity> subCategories) {
		this.subCategories = subCategories;
	}

	public Category toModel() {
		Category model = new Category();

		model.setId(this.id);
		model.setName(this.name);

		if (this.subCategories != null)
			model.setSubCategories(this.subCategories.stream().map(a -> a.toModel()).collect(toSet()));

		return model;
	}
}
