package com.flight.repository;

import com.flight.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Integer> {
    List<FlightModel> findBySourceAndDestinationAndFclass(String source, String destination, String fclass);
}
