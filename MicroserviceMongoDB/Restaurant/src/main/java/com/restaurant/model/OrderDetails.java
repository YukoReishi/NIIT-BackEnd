package com.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("OrderDetails")
public class OrderDetails {

    @Id
    private Long orderid;
    private String customername;
    private String foodname;
    private int qty;
    private String foodprice;

}
