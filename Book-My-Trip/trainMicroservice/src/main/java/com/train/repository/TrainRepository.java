package com.train.repository;

import com.train.model.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Trains, Integer> {

    List<Trains>findByTname(String tname);
    List<Trains>findBySource(String source);
    List<Trains>findByDestination(String destination);
    List<Trains>findBySourceAndDestination(String source, String destination);

    List<Trains>findByTclassAndSourceAndDestination(String tclass, String source, String destination);
}
