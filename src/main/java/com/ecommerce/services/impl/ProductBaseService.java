package com.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.BusinessEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.SubCategoryEntity;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.BusinessRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.SubCategoryRepository;
import com.ecommerce.services.ProductService;

@Service
public class ProductBaseService implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public List<Product> findAll() {
		List<ProductEntity> entity = this.repository.findAll();

		if (entity != null && !entity.isEmpty()) {
			return entity.stream().map(item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	@Override
	public Product findById(Long id) {
		Optional<ProductEntity> entity = repository.findById(id);

		if (entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}

	@Override
	public Product create(Product model) {

		if (model != null && model.getBusiness() != null && model.getSubCategories() != null) {

			Optional<BusinessEntity> businessResult = businessRepository.findById(model.getBusiness().getId());
			Set<SubCategoryEntity> subCategoriesResults = subCategoryRepository
					.findSubCategoryById(
							model.getSubCategories()
							.stream().map(a -> a.getId())
							.collect(Collectors.toList()));

			if(businessResult.isPresent() && !subCategoriesResults.isEmpty()) {
				ProductEntity entity = new ProductEntity(model);
				entity.setBusiness(businessResult.get());
				entity.setSubCategories(subCategoriesResults);
				
				return repository.save(entity).toModel();
			}
		}

		return null;
	}

	@Override
	public Product update(Product model) {

		return repository.findById(model.getId()).map(result -> {

			result.setName(model.getName());
			result.setDescription(model.getDescription());
			result.setPrice(model.getPrice());
			result.setPhoto(model.getPhoto());
			
			result.setBusiness(new BusinessEntity( model.getBusiness()));
		

			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});

	}

	@Override
	public boolean deleteById(Long id) {

		Optional<ProductEntity> result = repository.findById(id);

		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	/*private void findBusinessAndSubCategoryById(Business business, Set<SubCategory> subCategories) {
		
		Optional<BusinessEntity> businessResult = businessRepository.findById(business.getId());
		Set<SubCategoryEntity> subCategoriesResults = subCategoryRepository
				.findSubCategoryById(
						subCategories
						.stream().map(a -> a.getId())
						.collect(Collectors.toList()));
		
		if(businessResult.isPresent() && !subCategoriesResults.isEmpty()){
			
		}
	}*/

}