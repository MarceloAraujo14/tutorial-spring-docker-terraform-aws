package com.maraujo.contactbook.controller.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {Exception.class})
    public String handler(Exception ex){
        return ex.getMessage();
    }
}
