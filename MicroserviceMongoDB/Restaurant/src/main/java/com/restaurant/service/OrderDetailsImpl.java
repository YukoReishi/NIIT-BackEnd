package com.restaurant.service;

import com.restaurant.model.OrderDetails;
import com.restaurant.repository.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailsImpl implements IOrderDetails {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    public OrderDetails addOrder(OrderDetails orderDetails) {
        return orderDetailsRepo.save(orderDetails);
    }

    @Override
    public Optional<OrderDetails> orderByID(Long ID) {
        return orderDetailsRepo.findById(ID);
    }
}
