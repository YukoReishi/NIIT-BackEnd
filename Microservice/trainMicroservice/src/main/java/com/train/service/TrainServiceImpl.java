package com.train.service;

import com.train.model.Trains;
import com.train.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements ITrainService{

    @Autowired
    private TrainRepository repo;


    // Adding the Trains
    @Override
    public Trains addTrain(Trains trains){
        return repo.save(trains);
    }

    //Viewing the Trains
    @Override
    public List<Trains> viewAllTrain(){
        return repo.findAll();
    }

    // Viewing Trains by Name
    @Override
    public List<Trains> viewTrainsByName(String name){
        return repo.findByTname(name);
    }

    // Viewing Trains by Source
    @Override
    public List<Trains> viewTrainsBySource(String source){
        return repo.findBySource(source);
    }

    // Viewing Trains by Destination
    @Override
    public List<Trains> viewTrainsByDestination(String destination){
        return repo.findByDestination(destination);
    }

    public List<Trains> viewTrainsBySourceAndDestination(String source, String destination){
        return repo.findBySourceAndDestination(source, destination);
    }

    public List<Trains> viewtrainsorted(String source, String destination, String tclass){
        return repo.findByTclassAndSourceAndDestination(tclass, source, destination);
    }
}
