package com.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.parameters.UserParameter;
import com.ecommerce.presenters.UserPresenter;
import com.ecommerce.services.UserService;

import lib.easymart.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<UserPresenter> findByAttributes(
			@RequestParam(value = "user-email", required = false) String userEmail,
			@RequestParam(value = "user-name", required = false) String userName,
			@PageableDefault(page = 0, size = 50) Pageable pageable) {

		Page<User> result = this.service.findByAttributes(userEmail, userName, pageable);

		if (result != null) {
			return new ResponseEntity(result.map(a -> new UserPresenter(a)), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserPresenter> findById(@PathVariable Long id) {
		User result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(new UserPresenter(result), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<UserPresenter> create(@RequestBody @Valid UserParameter parameter) {

		if (parameter != null) {

			User model = this.service.create(parameter.toModel());

			if (model != null) {
				return new ResponseEntity(new UserPresenter(model), HttpStatus.CREATED);
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserPresenter> update(@PathVariable Long id, @RequestBody @Valid UserParameter parameter) {

		if (parameter != null) {
			User user = parameter.toModel();
			user.setId(id);

			User result = this.service.update(user);

			if (result != null) {
				return new ResponseEntity(new UserPresenter(result), HttpStatus.CREATED);
			}
		}

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		boolean result = this.service.deleteById(id);
		if (result) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
