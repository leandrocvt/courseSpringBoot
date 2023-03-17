package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.exception.BusinessRuleException;
import io.github.leandrocvt.exception.OrderNotFoundException;
import io.github.leandrocvt.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusinessRuleException(BusinessRuleException e){
        String message = e.getMessage();
        return new ApiErrors(message);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleOrderNotFoundException(OrderNotFoundException e){
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException e){
         List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map( erro -> erro.getDefaultMessage()).collect(Collectors.toList());
         return new ApiErrors(errors);
    }

}
