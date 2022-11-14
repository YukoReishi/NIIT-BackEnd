package com.restaurant.repository;

import com.restaurant.model.FoodItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemsRepo extends MongoRepository<FoodItems,Long> {
    List<FoodItems>findByFoodName(String foodName);
    Long deleteByFoodName(String foodName);
}
