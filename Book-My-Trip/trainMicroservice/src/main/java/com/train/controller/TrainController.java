package com.train.controller;

import com.train.model.Trains;
import com.train.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainServiceImpl trainservice;

    @PostMapping("/add")
    public Trains addTrains(@RequestBody Trains model){
        return trainservice.addTrain(model);
    }

    @GetMapping("/viewall")
    public ResponseEntity<List<Trains>> viewTrain(){
        return ResponseEntity.ok(trainservice.viewAllTrain());
    }

    @GetMapping("/viewname/{tname}")
    public ResponseEntity<List<Trains>> viewByName(@PathVariable("tname") String tname){
        return ResponseEntity.ok(trainservice.viewTrainsByName(tname));
    }

    @GetMapping("/viewsource/{source}")
    public ResponseEntity<List<Trains>> viewBySource(@PathVariable("source") String source){
        return ResponseEntity.ok(trainservice.viewTrainsBySource(source));
    }

    @GetMapping("/viewdestination/{destination}")
    public ResponseEntity<List<Trains>> viewByDestination(@PathVariable("destination") String destination){
        return ResponseEntity.ok(trainservice.viewTrainsByDestination(destination));
    }

    @GetMapping("/view/{source}/{destination}")
    public ResponseEntity<List<Trains>> viewBySourceAndDestination(@PathVariable("source") String source, @PathVariable("destination") String destination){
        return ResponseEntity.ok(trainservice.viewTrainsBySourceAndDestination(source, destination));
    }

    @GetMapping("/viewsorted/{source}/{destination}/{tclass}")
    public ResponseEntity<List<Trains>> viewsorted(@PathVariable("source") String source,
                                                   @PathVariable("destination") String destination,
                                                   @PathVariable("tclass") String tclass){
        return ResponseEntity.ok(trainservice.viewtrainsorted(source,destination, tclass));
    }
}
