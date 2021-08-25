package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("customers/{customerID}")
    public Customer getCustomerByID(@PathVariable int customerID) {

        return customerService.getCustomer(customerID);
    }

    @PostMapping("customers")
    public Customer createNewCustomer(@RequestBody Customer customer) {
        // id = null or id = 0 -> forces insert
        customer.setId(0);
        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

        return customer;
    }

}
