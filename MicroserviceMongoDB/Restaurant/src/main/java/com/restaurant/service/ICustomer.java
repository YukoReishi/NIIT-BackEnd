package com.restaurant.service;

import com.restaurant.model.Customer;

import java.util.List;

public interface ICustomer{
    public Customer addCustomer(Customer customer);
    public List<Customer> findCustomer(String customername);
}
