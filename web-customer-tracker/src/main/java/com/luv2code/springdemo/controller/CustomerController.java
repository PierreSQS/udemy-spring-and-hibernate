package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerDAO.getCustomers());
//        System.out.println("### a user from the DB: "+customerDAO.getCustomers().get(2));
        return "list-customers";
    }
}
