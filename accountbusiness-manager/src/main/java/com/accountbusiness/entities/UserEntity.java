package com.accountbusiness.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lib.easymart.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_usuario")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String password;

	public UserEntity(User model) {
		this.name = model.getName();
		this.email = model.getEmail();
		this.password = model.getPassword();
	}

	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public User toModel() {
		User model = new User();

		model.setId(this.id);
		model.setName(this.name);
		model.setEmail(this.email);
		model.setPassword(this.password);

		return model;
	}
}
