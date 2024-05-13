package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.Enum.Category;
import com.example.Shopping_Cart_Backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryAndPrice(Category category, int price);
}
