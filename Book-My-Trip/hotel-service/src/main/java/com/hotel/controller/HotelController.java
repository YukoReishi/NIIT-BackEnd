package com.hotel.controller;
import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelRepo hrepo;
    @GetMapping("/get")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hrepo.findAll());
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable("city") String city){
        return ResponseEntity.ok(hrepo.findByCity(city));
    }
//
//    @GetMapping("/{hroomPrice}")
//    public ResponseEntity<List<Hotel>>getHotelById(@PathVariable("hroomePrice") String hroomPrice){
//        return ResponseEntity.ok(hrepo.findByHroomPrice(hroomPrice));
//    }

    @PostMapping("/add")
    public ResponseEntity<Hotel>addHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hrepo.save(hotel));
    }

}
