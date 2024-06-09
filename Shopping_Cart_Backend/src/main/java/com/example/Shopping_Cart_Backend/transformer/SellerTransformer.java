package com.example.Shopping_Cart_Backend.transformer;

import com.example.Shopping_Cart_Backend.dto.RequestDto.SellerRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.SellerResponseDto;
import com.example.Shopping_Cart_Backend.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .emailId(sellerRequestDto.getEmailId())
                .mobNo(sellerRequestDto.getMobNo())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller){

        return SellerResponseDto.builder()
                .name(seller.getName())
                .mobNo(seller.getMobNo())
                .build();
    }
}
