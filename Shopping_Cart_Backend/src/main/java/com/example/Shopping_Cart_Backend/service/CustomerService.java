package com.example.Shopping_Cart_Backend.service;

import com.example.Shopping_Cart_Backend.dto.RequestDto.CustomerRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CustomerResponseDto;
import com.example.Shopping_Cart_Backend.model.Cart;
import com.example.Shopping_Cart_Backend.model.Customer;
import com.example.Shopping_Cart_Backend.repository.CustomerRepository;
import com.example.Shopping_Cart_Backend.transformer.CustomerTransformer;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Builder
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);
        Customer savedCustomer = customerRepository.save(customer);  // saves both customer and cart
        // prepare response Dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}
