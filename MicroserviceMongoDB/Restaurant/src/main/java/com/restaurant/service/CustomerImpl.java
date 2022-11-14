package com.restaurant.service;

import com.restaurant.model.Customer;
import com.restaurant.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImpl implements ICustomer{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> findCustomer(String customername) {
        return customerRepo.findByCustomername(customername);
    }
}
