package com.restaurant.service;

import com.restaurant.model.FoodItems;

import java.util.Optional;

public interface IFoodItems {
    public FoodItems addFood(FoodItems foodItems);
    public Optional<FoodItems> getFoodById(Long foodId);

    public Long deleteFood(String foodName);
}
