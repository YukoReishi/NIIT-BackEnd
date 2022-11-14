package com.train.service;

import com.train.model.Trains;

import java.util.List;

public interface ITrainService {
    public Trains addTrain(Trains trains);
    public List<Trains> viewAllTrain();
    public List<Trains> viewTrainsByName(String name);
    public List<Trains> viewTrainsBySource(String source);
    public List<Trains> viewTrainsByDestination(String destination);
}
