package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.OrderProductEntity;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long>{

}
