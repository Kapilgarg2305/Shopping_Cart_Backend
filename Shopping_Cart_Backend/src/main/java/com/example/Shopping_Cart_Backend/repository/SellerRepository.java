package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {


    Seller findByEmailId(String emailId);
}
