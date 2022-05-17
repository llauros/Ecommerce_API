package com.ecommerce.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Category;
import com.ecommerce.parameters.CategoryParameter;
import com.ecommerce.presenters.CategoryPresenter;
import com.ecommerce.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryPresenter>> findAll() {
		List<Category> result = this.service.findAll();

		if (result != null) {		
			return new ResponseEntity(result.stream().map(a -> new CategoryPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryPresenter> findById(@PathVariable Long id) {
		Category result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(new CategoryPresenter(result), HttpStatus.OK);	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@PostMapping
	public ResponseEntity<CategoryPresenter> create(@RequestBody CategoryParameter parameter) {
		
		if (parameter != null) {
			Category model = parameter.toModel();

			return new ResponseEntity(new CategoryPresenter(this.service.create(model)), HttpStatus.CREATED);	
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryPresenter> update(@PathVariable Long id, @RequestBody CategoryParameter parameter) {
		
		if (parameter != null) {
			Category user = parameter.toModel();
			user.setId(id);
			
			Category result = this.service.update(user);
			
			if(result != null) {				
				return new ResponseEntity(new CategoryPresenter(result), HttpStatus.CREATED);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);	
			}	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		boolean result = this.service.deleteById(id);

		if (result) {
			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}