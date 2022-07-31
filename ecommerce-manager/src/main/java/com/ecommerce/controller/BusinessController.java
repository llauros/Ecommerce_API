package com.ecommerce.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Business;
import com.ecommerce.parameters.BusinessParameter;
import com.ecommerce.presenters.BusinessPresenter;
import com.ecommerce.services.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private BusinessService service;

	@GetMapping
	public ResponseEntity<BusinessPresenter> findAll(
			@PageableDefault(page = 0, size = 20) Pageable pageable) {
		
		Page<Business> result = this.service.findAll(pageable);

		if (result != null) {
			return new ResponseEntity(result.map(a -> new BusinessPresenter(a)), HttpStatus.OK);
		}

		return new ResponseEntity<BusinessPresenter>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BusinessPresenter> findById(@PathVariable Long id) {
		Business result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity<BusinessPresenter>(new BusinessPresenter(result), HttpStatus.OK);
		}

		return new ResponseEntity<BusinessPresenter>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<BusinessPresenter> create(@RequestBody BusinessParameter parameter) {

		if (parameter != null) {

			Business model = this.service.create(parameter.toModel());

			if (model != null) {
				return new ResponseEntity<BusinessPresenter>(new BusinessPresenter(model), HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<BusinessPresenter>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BusinessPresenter> update(@PathVariable Long id, @RequestBody BusinessParameter parameter) {

		if (parameter != null) {
			Business model = parameter.toModel();
			model.setId(id);

			Business result = this.service.update(model);

			if (result != null) {
				return new ResponseEntity<BusinessPresenter>(new BusinessPresenter(result), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<BusinessPresenter>(HttpStatus.NO_CONTENT);
			}
		}

		return new ResponseEntity<BusinessPresenter>(HttpStatus.NO_CONTENT);
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
