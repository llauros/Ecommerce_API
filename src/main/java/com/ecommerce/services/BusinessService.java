package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Business;

public interface BusinessService {
	
    public Business create(Business business);

    public Business update(Business business);
    
    public Business findById(Long id);
    
    public List<Business> findAll();
	
    public boolean deleteById(Long id);
    
}
