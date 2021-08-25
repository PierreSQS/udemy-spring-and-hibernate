package com.luv2code.springdemo.entity;

import lombok.Data;

@Data
public class StatusErrorResponse {
    private int statusCode;
    private String message;
    long timeStamp;
}
