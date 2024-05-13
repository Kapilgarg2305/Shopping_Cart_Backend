package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
