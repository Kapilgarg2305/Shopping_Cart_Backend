package com.example.Shopping_Cart_Backend.dto.ResponseDto;

import com.example.Shopping_Cart_Backend.Enum.Category;
import com.example.Shopping_Cart_Backend.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String productName;

    String sellerName;

    Category category;

    int price;

    ProductStatus productStatus;
}
