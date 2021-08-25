package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.StatusErrorResponse;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StatusErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException custNfe) {
        // prepare the response
        var statusErrorRsp = new StatusErrorResponse();
        statusErrorRsp.setStatusCode(HttpStatus.NOT_FOUND.value());
        statusErrorRsp.setMessage(custNfe.getMessage());
        statusErrorRsp.setTimeStamp(System.currentTimeMillis());

        // return the Response Wrapper
        return new ResponseEntity<>(statusErrorRsp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StatusErrorResponse> handleCustomerException(Exception exc) {
        // prepare the response
        var statusErrorRsp = new StatusErrorResponse();
        statusErrorRsp.setStatusCode(HttpStatus.BAD_REQUEST.value());
        statusErrorRsp.setMessage(exc.getMessage());
        statusErrorRsp.setTimeStamp(System.currentTimeMillis());

        // return the Response Wrapper
        return new ResponseEntity<>(statusErrorRsp, HttpStatus.BAD_REQUEST);
    }
}
