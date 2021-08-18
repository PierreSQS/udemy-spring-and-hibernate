package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entities.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("list")
    public String listCustomers(Model model) {
        List<Customer> customersFromDB = customerService.getCustomers();
        model.addAttribute("customers", customersFromDB);
        System.out.println("### a user from the DB: "+ customersFromDB.get(2));
        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public String showAddCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }
}
