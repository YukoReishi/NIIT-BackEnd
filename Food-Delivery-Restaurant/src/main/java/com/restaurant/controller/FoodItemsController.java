package com.restaurant.controller;

import com.restaurant.model.FoodItems;
import com.restaurant.repository.FoodItemsRepo;
import com.restaurant.service.FoodItemsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FoodItemsController {
    @Autowired
    private FoodItemsImpl foodItemsImpl;

    @Autowired
    private FoodItemsRepo foodItemsRepo;

    @GetMapping("/fooditems")
    public ResponseEntity<List<FoodItems>> showFoodDetails(){
        return ResponseEntity.ok(foodItemsRepo.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<FoodItems> addFood(@RequestBody FoodItems foodItems){
     return ResponseEntity.ok(foodItemsImpl.addFood(foodItems));
    }


}
