package com.restaurant.repository;

import com.restaurant.model.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends MongoRepository<OrderDetails,Long> {
}
