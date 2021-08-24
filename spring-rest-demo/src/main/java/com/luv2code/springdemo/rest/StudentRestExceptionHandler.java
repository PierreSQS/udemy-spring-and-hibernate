package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.StudentNotFoundResponse;
import com.luv2code.springdemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundResponse> handleException(StudentNotFoundException exception) {
        var errorResp = new StudentNotFoundResponse();

        errorResp.setStatus(HttpStatus.NOT_FOUND.value());
        errorResp.setMessage(exception.getMessage());
        errorResp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResp,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundResponse> handleException(Exception exception) {
        var errorResp = new StudentNotFoundResponse();

        errorResp.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResp.setMessage(exception.getMessage());
        errorResp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResp,HttpStatus.BAD_REQUEST);

    }
}
