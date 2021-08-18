package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);

}
