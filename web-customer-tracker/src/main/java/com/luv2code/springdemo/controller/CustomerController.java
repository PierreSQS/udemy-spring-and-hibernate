package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entities.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showAddCustomerForm(@RequestParam(required = false) Long customerID, Model model) {

        // get the customer from the service
        Customer customer = customerService.getCustomerByID(customerID);

        // Add the customer to the model
        model.addAttribute("customer",customer);

        // return the customer form
        return "customer-form";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomerOnForm(@RequestParam(required = false) Long customerID) {

        // delete the customer from the service
        customerService.deleteCustomerByID(customerID);

        return "redirect:/customers/list";
    }

    @PostMapping("saveCustomer")
    public String submitCustomer(@ModelAttribute Customer customer) {
        // save the submitted customer
        customerService.saveCustomer(customer);
        return "redirect:/customers/list";
    }
}
