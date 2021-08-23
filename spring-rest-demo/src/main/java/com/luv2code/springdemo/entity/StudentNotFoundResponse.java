package com.luv2code.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentNotFoundResponse {
    private int status;
    private String message;
    private long timeStamp;
}
