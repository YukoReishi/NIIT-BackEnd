package com.orders.controller;

import com.orders.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/{username}")
    public ResponseEntity getOrderDetails(@PathVariable String username){
        try{
            return ResponseEntity.ok(orderServiceImpl.findOrderDetails(username));
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/place-order/{username}/{productId}/{qty}")
    public ResponseEntity placeOrder(@PathVariable String username,@PathVariable Long productId,@PathVariable int qty){
        System.out.println("inside placeOrder" + username+" "+productId);
        return ResponseEntity.ok(orderServiceImpl.placeOrder(username,productId,qty));

    }
}
