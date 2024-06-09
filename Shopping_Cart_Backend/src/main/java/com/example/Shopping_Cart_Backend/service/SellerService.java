package com.example.Shopping_Cart_Backend.service;

import com.example.Shopping_Cart_Backend.dto.RequestDto.SellerRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.SellerResponseDto;
import com.example.Shopping_Cart_Backend.model.Seller;
import com.example.Shopping_Cart_Backend.repository.SellerRepository;
import com.example.Shopping_Cart_Backend.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto){

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);
        Seller savedSeller = sellerRepository.save(seller);
        // prepare response Dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}
