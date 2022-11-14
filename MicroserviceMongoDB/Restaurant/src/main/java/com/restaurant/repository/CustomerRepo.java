package com.restaurant.repository;

import com.restaurant.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Long> {
    List<Customer> findByCustomername (String customername);
}
