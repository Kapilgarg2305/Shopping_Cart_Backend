package com.example.Shopping_Cart_Backend.exception;

public class EmptyCartException extends Exception{

    public EmptyCartException(String message){
        super(message);
    }
}
