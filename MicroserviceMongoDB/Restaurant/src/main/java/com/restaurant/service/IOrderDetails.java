package com.restaurant.service;

import com.restaurant.model.OrderDetails;

import java.util.Optional;

public interface IOrderDetails {
    public OrderDetails addOrder(OrderDetails orderDetails);
    public Optional<OrderDetails> orderByID(Long ID);
}
