package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.SubCategoryEntity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{

}