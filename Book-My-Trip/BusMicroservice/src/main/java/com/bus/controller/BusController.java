package com.bus.controller;

import com.bus.entity.BusModel;
import com.bus.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusServiceImpl service;

    @PostMapping("/add")
    private BusModel addBus(@RequestBody BusModel model){
        return service.addBus(model);
    }

    @GetMapping("/viewall")
    private List<BusModel> viewall(){
        return service.viewBus();
    }

    @GetMapping("/viewsorted/{source}/{destination}/{bclass}")
    private List<BusModel> viewsorted(@PathVariable("source") String source,
                                      @PathVariable("destination") String destination,
                                      @PathVariable("bclass") String bclass){
        return service.viewBusBySrcnDestnclass(source, destination, bclass);
    }

}
