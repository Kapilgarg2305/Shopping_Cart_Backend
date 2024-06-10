package com.example.Shopping_Cart_Backend.controller;

import com.example.Shopping_Cart_Backend.dto.RequestDto.CheckoutCartRequestDto;
import com.example.Shopping_Cart_Backend.dto.RequestDto.ItemRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CartResponseDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.OrderResponseDto;
import com.example.Shopping_Cart_Backend.model.Item;
import com.example.Shopping_Cart_Backend.repository.OrderRepository;
import com.example.Shopping_Cart_Backend.service.CartService;
import com.example.Shopping_Cart_Backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){

        try{
            Item item = itemService.createItem(itemRequestDto);
            CartResponseDto cartResponseDto = cartService.addToCart(item,itemRequestDto);
            return new ResponseEntity(cartResponseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkout")   // correct the bug
    public ResponseEntity checkoutCart(@RequestBody CheckoutCartRequestDto checkoutCartRequestDto){

        try{
            OrderResponseDto orderResponseDto = cartService.checkOutCart(checkoutCartRequestDto);
            return new ResponseEntity(orderResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
