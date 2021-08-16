package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("list")
    public String listCustomers(Model model) {
        List<Customer> customersFromDB = customerDAO.getCustomers();
        model.addAttribute("customers", customersFromDB);
        System.out.println("### a user from the DB: "+ customersFromDB.get(2));
        return "list-customers";
    }
}
