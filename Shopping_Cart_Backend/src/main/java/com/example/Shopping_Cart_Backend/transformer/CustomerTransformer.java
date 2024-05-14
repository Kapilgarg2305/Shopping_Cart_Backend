package com.example.Shopping_Cart_Backend.transformer;

import com.example.Shopping_Cart_Backend.dto.RequestDto.CustomerRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CustomerResponseDto;
import com.example.Shopping_Cart_Backend.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        Customer savedCustomer= Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .build();
         return savedCustomer;

    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .build();
    }
}
