package com.restaurant.controller;

import com.restaurant.model.Customer;
import com.restaurant.repository.CustomerRepo;
import com.restaurant.service.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerImpl customerImpl;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        return ResponseEntity.ok(customerImpl.addCustomer(customer));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> login(@PathVariable Long customerId){
        return ResponseEntity.ok(customerImpl.findCustomer(customerId).orElse(null));
    }




}
