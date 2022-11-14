package com.restaurant.service;

import com.restaurant.model.FoodItems;

import java.util.List;

public interface IFoodItems {
    public FoodItems addFood(FoodItems fooditems);
    public List<FoodItems> viewFoodByName(String foodname);
    public void deleteFood(String foodname);
}
