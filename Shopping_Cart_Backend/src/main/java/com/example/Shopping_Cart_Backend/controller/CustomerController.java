package com.example.Shopping_Cart_Backend.controller;

import com.example.Shopping_Cart_Backend.dto.RequestDto.CustomerRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CustomerResponseDto;
import com.example.Shopping_Cart_Backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;




    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/deployed")
    public String tochk(){
        return "done";
    }


}
