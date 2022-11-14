package com.flight.controller;

import com.flight.model.FlightModel;
import com.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping("/add")
    public FlightModel addFlight(@RequestBody FlightModel model){
        return service.addFlight(model);
    }

    @GetMapping("/viewall")
    public List<FlightModel> viewall(){
        return service.viewall();
    }

    @GetMapping("/viewsorted/{source}/{destination}/{fclass}")
    public List<FlightModel> viewsort(@PathVariable("source") String source,
                                      @PathVariable("destination") String destination,
                                      @PathVariable("fclass") String fclass){
        return service.viewsorted(source, destination, fclass);
    }
}
