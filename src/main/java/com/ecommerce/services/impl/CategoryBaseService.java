package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.CategoryEntity;
import com.ecommerce.models.Category;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.services.CategoryService;

@Service
public class CategoryBaseService implements CategoryService{

	@Autowired
	private CategoryRepository repository;

	@Override
	public List<Category> findAll() {
		List<CategoryEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public Category findById(Long id) {
		Optional<CategoryEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}
	
	@Override
	public Category create(Category model) {
		CategoryEntity entity = repository.save(new CategoryEntity(model));
		
		return entity.toModel();
	}

	@Override
	public Category update(Category model) {
			
		return repository.findById(model.getId()).map( result -> {
			
			result.setName(model.getName());
			
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});
		
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<CategoryEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}