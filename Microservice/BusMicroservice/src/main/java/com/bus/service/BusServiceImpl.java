package com.bus.service;

import com.bus.entity.BusModel;
import com.bus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl {

    @Autowired
    private BusRepository repo;

    // ADD the data
    public BusModel addBus(BusModel model){
        return repo.save(model);
    }

    // Viewing all the data
    public List<BusModel> viewBus(){
        return repo.findAll();
    }

    // Search using Source, Destination and Class
    public List<BusModel> viewBusBySrcnDestnclass(String source, String destination, String bclass){
        return repo.findBySourceAndDestinationAndBclass(source, destination, bclass);
    }
}
