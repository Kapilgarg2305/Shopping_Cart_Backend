package com.example.Shopping_Cart_Backend.service;


import com.example.Shopping_Cart_Backend.dto.RequestDto.CardRequestDto;
import com.example.Shopping_Cart_Backend.dto.ResponseDto.CardResponseDto;
import com.example.Shopping_Cart_Backend.exception.CustomerNotFoundException;
import com.example.Shopping_Cart_Backend.model.Card;
import com.example.Shopping_Cart_Backend.model.Customer;
import com.example.Shopping_Cart_Backend.repository.CustomerRepository;
import com.example.Shopping_Cart_Backend.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer = customerRepository.findByEmailId(cardRequestDto.getEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Invalid email id!!!");
        }

        // dto -> entity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        // save customer and card
        Customer savedCustomer = customerRepository.save(customer);

        // prepare response Dto
        return CardTransformer.CardToCardResponseDto(card);
    }
}
