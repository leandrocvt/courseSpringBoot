package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.exception.BusinessRuleException;
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

}
