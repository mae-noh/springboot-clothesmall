package com.shop.clothesmall.exception;

public class BusinessException extends RuntimeException{
    private String message;

    public BusinessException(String message){
        this.message = message;
    }
}
