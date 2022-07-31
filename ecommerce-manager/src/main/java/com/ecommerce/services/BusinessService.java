package com.ecommerce.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.models.Business;

public interface BusinessService {
	
    public Business create(Business business);

    public Business update(Business business);
    
    public Business findById(Long id);
    
    public Page<Business> findAll(Pageable pageable);
	
    public boolean deleteById(Long id);
}
