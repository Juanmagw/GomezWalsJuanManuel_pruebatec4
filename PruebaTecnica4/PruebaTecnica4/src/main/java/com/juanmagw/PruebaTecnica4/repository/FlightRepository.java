package com.juanmagw.PruebaTecnica4.repository;

import com.juanmagw.PruebaTecnica4.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
