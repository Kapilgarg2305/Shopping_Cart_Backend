package com.example.Shopping_Cart_Backend.exception;

public class OutOfStockException extends Exception{

    public OutOfStockException(String message){
        super(message);
    }
}
