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

    @GetMapping("/kaka")
        public String esehi(){
            return "done";
        }


    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponseDto, HttpStatus.CREATED);
    }

    // get all female customers between age 20-30

    // get all male customers less than 45

    // customers who have ordered atleast 'k' orders

}
