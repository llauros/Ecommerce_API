package com.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecommerce.models.Business;

@Entity
@Table(name = "tb_negocio")
public class BusinessEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "descricao")
	private String description;
	
	/*@Column(name = "foto_perfil")
	private String profilePicture;
	
	@Column(name = "banner")
	private String bannerImage;

	@Column(name = "senha")
	private Date createdAt;
	
	@Column(name = "senha")
	private Date updatedAt;*/
	
	public BusinessEntity() {}
	
	public BusinessEntity(Business model) {
		if(model != null) {
			this.name = model.getName();
			this.description = model.getDescription();
		}
	}

	public BusinessEntity(String name, String description) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Business toModel() {
		Business model = new Business();
		
		model.setId(this.id);
		model.setName(this.name);
		model.setDescription(this.description);
		
		return model;
	}
	
}
