package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.BusinessEntity;
import com.ecommerce.entities.UserEntity;
import com.ecommerce.models.Business;
import com.ecommerce.repositories.BusinessRepository;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.services.BusinessService;

@Service
public class BusinessBaseService implements BusinessService {

	@Autowired
	private BusinessRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Business> findAll() {

		List<BusinessEntity> entity = this.repository.findAll();

		if (entity != null && !entity.isEmpty()) {
			return entity.stream().map(item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	@Override
	public Business findById(Long id) {
		Optional<BusinessEntity> entity = repository.findById(id);

		if (entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}

	@Override
	public Business create(Business newBusiness) {

		if (newBusiness.getOwnerUser() != null) {

			Optional<BusinessEntity> validateExistingBusiness = repository
					.findBusinessByOwnerUser(newBusiness.getOwnerUser().getId());
			
			if (validateExistingBusiness.isEmpty()) {

				Optional<UserEntity> result = userRepository.findById(newBusiness.getOwnerUser().getId());

				if (result.isPresent()) {
					BusinessEntity entity = new BusinessEntity(newBusiness);
					entity.setOwnerUser(result.get());

					return repository.save(entity).toModel();
				}
			}
		}

		return null;
	}

	@Override
	public Business update(Business model) {

		return repository.findById(model.getId()).map(result -> {

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
