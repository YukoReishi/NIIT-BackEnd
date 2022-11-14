package com.restaurant.controller;

import com.restaurant.model.Customer;
import com.restaurant.model.FoodItems;
import com.restaurant.model.OrderDetails;
import com.restaurant.service.CustomerImpl;
import com.restaurant.service.FoodItemsImpl;
import com.restaurant.service.OrderDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsImpl orderDetailsImpl;
    @Autowired
    private FoodItemsImpl foodItemsImpl;
    @Autowired
    private CustomerImpl customerImpl;

    Long id = 101L;

    @GetMapping("/order/{id}")
    public Optional<OrderDetails> orderByID(@PathVariable("id") Long id){
        return orderDetailsImpl.orderByID(id);
    }

    @GetMapping("/saveorder/{customerName}/{foodName}/{qty}")
    public OrderDetails saveOrder(@PathVariable("customerName") String customerName, @PathVariable("foodName") String foodName,@PathVariable("qty") int qty){

        List<Customer> customers = customerImpl.findCustomer(customerName);
        List<FoodItems> foodItems = foodItemsImpl.viewFoodByName(foodName);

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setOrderid(id++);
        orderDetails.setFoodname(foodItems.get(0).getFoodname());
        orderDetails.setCustomername(customers.get(0).getCustomername());
        orderDetails.setQty(qty);
        orderDetails.setFoodprice(String.valueOf(Integer.parseInt(foodItems.get(0).getFoodprice()) * qty));

        return orderDetailsImpl.addOrder(orderDetails);
    }
}
