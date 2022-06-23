package com.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
