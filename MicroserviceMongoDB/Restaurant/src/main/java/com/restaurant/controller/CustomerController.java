package com.restaurant.controller;

import com.restaurant.model.Customer;
import com.restaurant.service.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerImpl customerservice;

    @PostMapping("/addcustomer")
    public Customer register(@RequestBody Customer customer){
        return customerservice.addCustomer(customer);
    }

    @GetMapping("/{name}")
    public List<Customer> login(@PathVariable("name") String name){
        return customerservice.findCustomer(name);
    }




}
