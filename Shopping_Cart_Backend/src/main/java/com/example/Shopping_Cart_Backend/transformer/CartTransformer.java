package com.example.Shopping_Cart_Backend.transformer;

import com.example.Shopping_Cart_Backend.dto.ResponseDto.CartResponseDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.ItemResponseDto;
import com.example.Shopping_Cart_Backend.model.Cart;
import com.example.Shopping_Cart_Backend.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto CartToCartResponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtos.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtos)
                .build();
    }
}
