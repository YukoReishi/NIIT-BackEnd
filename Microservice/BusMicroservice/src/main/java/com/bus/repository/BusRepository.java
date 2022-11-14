package com.bus.repository;

import com.bus.entity.BusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<BusModel, Integer> {


    // Sorting the database
    // First Letter of the variable should be in caps.
    List<BusModel> findBySource(String source);
    List<BusModel> findByDestination(String destination);

    List<BusModel> findBySourceAndDestination(String source, String destination);
    List<BusModel> findBySourceAndDestinationAndBclass(String source, String destination, String bclass);
}
