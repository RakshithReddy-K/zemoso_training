package com.ecommerce.store.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public String handleException(ProductNotFoundException exception){
        return "/error/product-not-found";
    }

    @ExceptionHandler
    public String handleException(UserNotFoundException exception){
        return "/error/user-not-found";
    }


}
