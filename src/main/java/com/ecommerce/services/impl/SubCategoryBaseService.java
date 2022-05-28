package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.CategoryEntity;
import com.ecommerce.entities.SubCategoryEntity;
import com.ecommerce.models.SubCategory;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.SubCategoryRepository;
import com.ecommerce.services.SubCategoryService;

@Service
public class SubCategoryBaseService implements SubCategoryService {

	@Autowired
	private SubCategoryRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<SubCategory> findAll() {
		List<SubCategoryEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public SubCategory findById(Long id) {
		Optional<SubCategoryEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}
	
	@Override
	public SubCategory create(SubCategory model) {
		
		if(model != null) {
			SubCategoryEntity entity = new SubCategoryEntity(model);
			
			return repository.save(entity).toModel();
			
			
			/*if(model.getCategory() != null) {
				Optional<CategoryEntity> categoryEntity = categoryRepository.findById(model.getCategory().getId());
				
				if(categoryEntity.isPresent()) {
					entity.setCategory(categoryEntity.get());
					
					return repository.save(entity).toModel();
				}				
			}*/	
		}

		return null;
	}

	@Override
	public SubCategory update(SubCategory model) {
		CategoryEntity category = null;
		
		/*return repository.findById(model.getId()).map( result -> {		
			
			result.setName(model.getName());
			if (model.getCategory() != null) {
				Optional<CategoryEntity> categoryEntity = categoryRepository.findById(model.getCategory().getId());
				
				if(categoryEntity.isPresent()) {
					result.setCategory(categoryEntity.get());
				}
			}
			
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});*/
		return null;
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<SubCategoryEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}