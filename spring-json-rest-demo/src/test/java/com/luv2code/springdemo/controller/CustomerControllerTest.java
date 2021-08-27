package com.luv2code.springdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
@EnableWebMvc
class CustomerControllerTest {

    @Mock
    CustomerService customerSrvMock;

    MockMvc mockMvc;

    Customer customerMock1, customerMock2;


    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(new CustomerController(customerSrvMock)).build();
        customerMock1 = new Customer("Customer1","Mock1","customer1@web.de");
        customerMock2 = new Customer("Customer2","Mock2","customer2@web.de");
    }

    @Test
    void getCustomers() throws Exception {
        // Given
        List<Customer> customersMock = Arrays.asList(customerMock1, customerMock2);

        when(customerSrvMock.getCustomers()).thenReturn(customersMock);

        // When and Then
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", equalTo("Customer1")))
                .andDo(print());
    }

    @Test
    void createNewCustomer() throws Exception {
        // Given
        System.out.println("Customer Mock:"+customerMock2);

        // When and Then
        mockMvc.perform(post("/api/customers")
                .content(new ObjectMapper().writeValueAsString(customerMock2))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("Customer2")))
                .andDo(print());

        verify(customerSrvMock).saveCustomer(customerMock2);
    }
}