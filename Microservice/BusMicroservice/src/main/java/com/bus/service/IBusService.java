package com.bus.service;

import com.bus.entity.BusModel;

import java.util.List;

public interface IBusService {
    public BusModel addBus(BusModel model);
    public List<BusModel> viewBus();
    public List<BusModel> viewBusBySource(String source);
    public List<BusModel> viewBusByDestination(String destination);
    public List<BusModel> viewBusBySrcAndDest(String source, String destination);
    public List<BusModel> viewBusBySrcnDestnclass(String source, String destination, String bclass);
}
