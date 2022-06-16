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

import com.ecommerce.parameters.BusinessParameter;
import com.ecommerce.presenters.BusinessPresenter;
import com.ecommerce.services.BusinessService;

import lib.easymart.models.Business;

@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private BusinessService service;

	@GetMapping
	public ResponseEntity<List<BusinessPresenter>> findAll() {
		List<Business> result = this.service.findAll();

		if (result != null) {
			return new ResponseEntity(result.stream().map(a -> new BusinessPresenter(a)).collect(Collectors.toList()),
					HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BusinessPresenter> findById(@PathVariable Long id) {
		Business result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(new BusinessPresenter(result), HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<BusinessPresenter> create(@RequestBody BusinessParameter parameter) {

		if (parameter != null) {
			
			Business model = this.service.create(parameter.toModel());

			if(model != null) {
				return new ResponseEntity(new BusinessPresenter(model), HttpStatus.CREATED);
			}		
		}

		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BusinessPresenter> update(@PathVariable Long id, @RequestBody BusinessParameter parameter) {

		if (parameter != null) {
			Business model = parameter.toModel();
			model.setId(id);

			Business result = this.service.update(model);

			if (result != null) {
				return new ResponseEntity(new BusinessPresenter(result), HttpStatus.CREATED);
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
