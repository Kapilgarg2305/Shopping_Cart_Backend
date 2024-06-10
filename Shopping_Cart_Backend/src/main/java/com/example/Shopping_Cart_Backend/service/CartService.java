package com.example.Shopping_Cart_Backend.service;

import com.example.Shopping_Cart_Backend.dto.RequestDto.CheckoutCartRequestDto;
import com.example.Shopping_Cart_Backend.dto.RequestDto.ItemRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CartResponseDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.OrderResponseDto;
import com.example.Shopping_Cart_Backend.exception.CustomerNotFoundException;
import com.example.Shopping_Cart_Backend.exception.EmptyCartException;
import com.example.Shopping_Cart_Backend.exception.InsufficientQuantityException;
import com.example.Shopping_Cart_Backend.exception.InvalidCardException;
import com.example.Shopping_Cart_Backend.model.*;
import com.example.Shopping_Cart_Backend.repository.*;
import com.example.Shopping_Cart_Backend.transformer.CartTransformer;
import com.example.Shopping_Cart_Backend.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public CartResponseDto addToCart(Item item, ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        Product product = productRepository.findById(itemRequestDto.getProductId()).get();

        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal()+item.getRequiredQuantity()*product.getPrice());
        cart.getItems().add(item);
        item.setCart(cart);
        item.setProduct(product);

        Cart savedCart = cartRepository.save(cart);  // saves both cart and item
        Item savedItem = cart.getItems().get(cart.getItems().size()-1);
        product.getItems().add(savedItem);
        //prepare response dto
        return CartTransformer.CartToCartResponseDto(savedCart);
    }

    public OrderResponseDto checkOutCart(CheckoutCartRequestDto checkoutCartRequestDto) throws CustomerNotFoundException, InvalidCardException, EmptyCartException, InsufficientQuantityException {

        Customer customer = customerRepository.findByEmailId(checkoutCartRequestDto.getEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Card card = cardRepository.findByCardNo(checkoutCartRequestDto.getCardNo());
        Date date = new Date();
        if(card==null || card.getCvv()!= checkoutCartRequestDto.getCvv() || date.after(card.getValidTill())){
            throw new InvalidCardException("Sorry! You can't use this card!");
        }

        Cart cart = customer.getCart();
        if(cart.getItems().size()==0){
            throw new EmptyCartException("Cart is empty!!");
        }

        try{
          OrderEntity order = orderService.placeOrder(cart,card);
          resetCart(cart);

          OrderEntity savedOrder = orderRepository.save(order);
          customer.getOrders().add(savedOrder);

          return OrderTransformer.OrderToOrderResponseDto(savedOrder);
        }
        catch (InsufficientQuantityException e){
            throw e;
        }
    }

    private void resetCart(Cart cart){

        cart.setCartTotal(0);
        for(Item item: cart.getItems())
            item.setCart(null);
        cart.setItems(new ArrayList<>());
    }
}
