package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
