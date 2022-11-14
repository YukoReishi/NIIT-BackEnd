package com.hotel.repository;

import com.hotel.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel,Long>{
    List<Hotel>findByCity(String city);
    //List<Hotel>findByHroomPrice(String hroomPrice);
}
