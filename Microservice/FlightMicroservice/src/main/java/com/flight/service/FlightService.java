package com.flight.service;

import com.flight.model.FlightModel;
import com.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repo;

    public FlightModel addFlight(FlightModel model){
        return repo.save(model);
    }

    public List<FlightModel> viewall(){
        return repo.findAll();
    }

    public List<FlightModel> viewsorted(String source, String destination, String fclass){
        return repo.findBySourceAndDestinationAndFclass(source, destination, fclass);
    }
}
