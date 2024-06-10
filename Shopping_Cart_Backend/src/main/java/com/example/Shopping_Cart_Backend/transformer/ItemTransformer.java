package com.example.Shopping_Cart_Backend.transformer;

import com.example.Shopping_Cart_Backend.dto.ResponseDto.ItemResponseDto;
import com.example.Shopping_Cart_Backend.model.Item;

public class ItemTransformer {

    public static Item ItemRequestDtoToItem(int quantity){

        return Item.builder()
                .requiredQuantity(quantity)
                .build();
    }

    public static ItemResponseDto ItemToItemResponseDto(Item item) {

        return ItemResponseDto.builder()
                .quantityAdded(item.getRequiredQuantity())
                .productName(item.getProduct().getName())
                .price(item.getProduct().getPrice())
                .build();
    }
}
