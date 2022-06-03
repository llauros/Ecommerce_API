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

import com.ecommerce.models.Product;
import com.ecommerce.parameters.ProductParameter;
import com.ecommerce.presenters.ProductPresenter;
import com.ecommerce.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductPresenter>> findAll() {
		List<Product> result = this.service.findAll();

		if (result != null) {		
			return new ResponseEntity(result.stream().map(a -> new ProductPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductPresenter> findById(@PathVariable Long id) {
		Product result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(new ProductPresenter(result), HttpStatus.OK);	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@PostMapping
	public ResponseEntity<ProductPresenter> create(@RequestBody ProductParameter parameter) {
		
		if (parameter != null) {
			Product result = this.service.create(parameter.toModel());

			if(result != null) {
				return new ResponseEntity<ProductPresenter>(new ProductPresenter(result), HttpStatus.CREATED);
			}		
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductPresenter> update(@PathVariable Long id, @RequestBody ProductParameter parameter) {
		
		if (parameter != null) {
			Product user = parameter.toModel();
			user.setId(id);
			
			Product result = this.service.update(user);
			
			if(result != null) {				
				return new ResponseEntity(new ProductPresenter(result), HttpStatus.CREATED);
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
