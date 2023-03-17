package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.exception.BusinessRuleException;
import io.github.leandrocvt.exception.OrderNotFoundException;
import io.github.leandrocvt.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
