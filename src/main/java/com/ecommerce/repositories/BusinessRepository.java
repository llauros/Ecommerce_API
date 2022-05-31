package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.BusinessEntity;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, Long> {

}
