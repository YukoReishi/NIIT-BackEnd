package com.restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("OrderDetails")
public class OrderDetails {

    @Id
    private Long orderId;

    private String customerName;

    private String foodName;
    private int qty;
    private String foodPrice;

    public OrderDetails() {
        super();
    }

    public OrderDetails(Long orderId,String customerName, String foodName, int qty, String foodPrice) {
        this.orderId = orderId;
        this.customerName=customerName;
        this.foodName = foodName;
        this.qty = qty;
        this.foodPrice = foodPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
}
