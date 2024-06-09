package com.example.Shopping_Cart_Backend.transformer;

import com.example.Shopping_Cart_Backend.Enum.ProductStatus;
import com.example.Shopping_Cart_Backend.dto.RequestDto.ProductRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.ProductResponseDto;
import com.example.Shopping_Cart_Backend.model.Product;

public class ProductTransformer {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .name(productRequestDto.getName())
                .category(productRequestDto.getCategory())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProducToProductResponseDto(Product product){

        return ProductResponseDto.builder()
                .productName(product.getName())
                .sellerName(product.getSeller().getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .productStatus(product.getProductStatus())
                .build();
    }
}
