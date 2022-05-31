package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.BusinessEntity;
import com.ecommerce.models.Business;
import com.ecommerce.repositories.BusinessRepository;
import com.ecommerce.services.BusinessService;

@Service
public class BusinessBaseService implements BusinessService{

	@Autowired
	private BusinessRepository repository;

	@Override
	public List<Business> findAll() {
		
		List<BusinessEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public Business findById(Long id) {
		Optional<BusinessEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}
	
	@Override
	public Business create(Business user) {
		BusinessEntity entity = repository.save(new BusinessEntity(user));
		
		return entity.toModel();
	}

	@Override
	public Business update(Business model) {
			
		return repository.findById(model.getId()).map( result -> {
			
			result.setName(model.getName());
			result.setDescription(model.getDescription());
						
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});
		
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<BusinessEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}