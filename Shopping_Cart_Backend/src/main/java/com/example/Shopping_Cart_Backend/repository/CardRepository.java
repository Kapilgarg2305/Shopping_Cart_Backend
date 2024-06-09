package com.example.Shopping_Cart_Backend.repository;

import com.example.Shopping_Cart_Backend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    Card findByCardNo(String cardNo);

}
