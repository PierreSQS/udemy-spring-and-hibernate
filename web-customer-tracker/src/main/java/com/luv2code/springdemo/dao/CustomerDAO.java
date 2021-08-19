package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer findByID(Long customerID);

    void deleteCustomerByID(Long customerID);
}
