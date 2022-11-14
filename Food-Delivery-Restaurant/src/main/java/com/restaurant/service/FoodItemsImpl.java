package com.restaurant.service;

import com.restaurant.model.FoodItems;
import com.restaurant.repository.FoodItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FoodItemsImpl implements IFoodItems{
    @Autowired
    private FoodItemsRepo foodItemsRepo;

    @Override
    public FoodItems addFood(FoodItems foodItems) {
        return foodItemsRepo.save(foodItems);
    }

    @Override
    public Optional<FoodItems> getFoodById(Long foodId) {
        return foodItemsRepo.findById(foodId);
    }

    @Override
    public Long deleteFood(String foodName) {
        return foodItemsRepo.deleteByFoodName(foodName);
    }

}
