package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //Customer findByEmailId(String emailId);
}
