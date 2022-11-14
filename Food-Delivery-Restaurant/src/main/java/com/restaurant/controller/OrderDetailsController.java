package com.restaurant.controller;

import com.restaurant.model.Customer;
import com.restaurant.model.FoodItems;
import com.restaurant.model.OrderDetails;
import com.restaurant.service.CustomerImpl;
import com.restaurant.service.FoodItemsImpl;
import com.restaurant.service.OrderDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class OrderDetailsController {

    @Autowired
    private OrderDetailsImpl orderDetailsImpl;
    @Autowired
    private FoodItemsImpl foodItemsImpl;
    @Autowired
    private CustomerImpl customerImpl;

    Long id = 101L;

    @GetMapping("order/{id}")
    public Optional<OrderDetails> orderByID(@PathVariable("id") Long id){
        return Optional.ofNullable(orderDetailsImpl.orderByID(id).orElse(null));
    }

    @GetMapping("saveorder/{customerId}/{foodId}/{qty}")
    public ResponseEntity<OrderDetails> saveOrder(@PathVariable("customerId") Long customerId, @PathVariable("foodId") Long foodId, @PathVariable("qty") int qty){

        Optional<Customer> customers = customerImpl.findCustomer(customerId);
        Optional<FoodItems> foodItems = foodItemsImpl.getFoodById(foodId);

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setOrderId(id++);
        orderDetails.setFoodName(foodItems.get().getFoodName());
        orderDetails.setCustomerName(customers.get().getCustomerName());
        orderDetails.setQty(qty);
        orderDetails.setFoodPrice(String.valueOf(Integer.parseInt(foodItems.get().getFoodPrice()) * qty));

        return ResponseEntity.ok(orderDetailsImpl.addOrder(orderDetails));
    }
}
