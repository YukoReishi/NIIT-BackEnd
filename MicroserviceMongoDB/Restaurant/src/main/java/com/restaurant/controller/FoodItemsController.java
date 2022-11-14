package com.restaurant.controller;

import com.restaurant.model.FoodItems;
import com.restaurant.repository.FoodItemsRepo;
import com.restaurant.service.FoodItemsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodItemsController {
    @Autowired
    private FoodItemsImpl foodItemsImpl;
    @Autowired
    private FoodItemsRepo foodItemsRepo;


    @GetMapping("/fooditems")
    public List<FoodItems> showFoodDetails(){
        return foodItemsRepo.findAll();
    }

    @GetMapping("/fooditems/{foodname}")
    public List<FoodItems> viewFoodByName(@PathVariable("foodname") String foodname){
        return foodItemsImpl.viewFoodByName(foodname);
    }

    @PostMapping("/add")
    public FoodItems addFood(@RequestBody FoodItems foodItems){
     return foodItemsImpl.addFood(foodItems);
    }

    @DeleteMapping("/delete/{foodname}")
    public void deleteFood(@PathVariable("foodname") String foodname){
        foodItemsImpl.deleteFood(foodname);
    }
}
