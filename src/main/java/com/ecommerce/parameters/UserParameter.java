package com.ecommerce.parameters;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ecommerce.models.User;

public class UserParameter {

	@NotNull @NotEmpty
	@Length(min = 3, max = 100)
	private String name;

	@NotEmpty
	@Email
	private String email;
	
	@NotNull @NotEmpty
	@Length(min = 8, max = 100)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User toModel() {
		User model = new User();

		model.setName(this.name);
		model.setEmail(this.email);
		model.setPassword(this.password);

		return model;
	}

}
