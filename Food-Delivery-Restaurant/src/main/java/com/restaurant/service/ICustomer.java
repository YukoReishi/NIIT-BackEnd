package com.restaurant.service;

import com.restaurant.model.Customer;

import java.util.Optional;

public interface ICustomer{

    public Customer addCustomer(Customer customer);

    public Optional<Customer> findCustomer(Long customerId);
}
