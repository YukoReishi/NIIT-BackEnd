package com.restaurant.repository;

import com.restaurant.model.FoodItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemsRepo extends MongoRepository<FoodItems,Long> {
    List<FoodItems> findByFoodname(String foodname);

    void deleteByFoodname(String foodname);
}
