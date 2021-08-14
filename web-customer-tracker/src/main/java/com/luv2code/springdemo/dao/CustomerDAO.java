package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
