package com.orders.service;

import com.orders.model.Orders;

import java.util.List;

public interface IOrderService {
    public List<Orders> findOrderDetails(String username) throws Exception;
    public Orders placeOrder(String username, Long prodcutId,int qty);
}
