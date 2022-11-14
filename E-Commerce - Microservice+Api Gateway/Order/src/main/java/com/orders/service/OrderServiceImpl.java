package com.orders.service;

import com.orders.model.Orders;
import com.orders.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Orders> findOrderDetails(String username) throws Exception {
        if(orderRepo.findByUsername(username).isEmpty()) {
            throw new Exception("No Order Details Found");
        }else{
            return orderRepo.findByUsername(username);
        }
    }

    @Override
    public Orders placeOrder(String username, Long productId,int qty) {
        Orders orders = new Orders();
        System.out.println("inside place order service");
        List mobile = restTemplate.getForObject("http://localhost:9004/mobile/byId/"+productId,List.class);
        System.out.println(mobile.get(0));
        System.out.println(mobile.get(0));
        HashMap mobileMap = (HashMap) mobile.get(0);
        System.out.println(mobileMap.get("mobilePrice"));
        orders.setUsername(username);
        orders.setProductId(productId);
        orders.setProductType("Mobile");
        orders.setQty(qty);
        orders.setOrderDate(LocalDateTime.now());
        orders.setTotalPrice(qty * (int)mobileMap.get("mobilePrice"));
        return orderRepo.save(orders);
    }
}
