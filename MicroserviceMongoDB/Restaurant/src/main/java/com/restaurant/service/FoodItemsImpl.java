package com.restaurant.service;

import com.restaurant.model.FoodItems;
import com.restaurant.repository.FoodItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemsImpl implements IFoodItems{
    @Autowired
    private FoodItemsRepo foodrepo;

    @Override
    public FoodItems addFood(FoodItems fooditems) {
        return foodrepo.save(fooditems);
    }

    @Override
    public List<FoodItems> viewFoodByName(String foodname) {
        return foodrepo.findByFoodname(foodname);
    }

    @Override
    public void deleteFood(String foodname) {
        foodrepo.deleteByFoodname(foodname);
    }

}
