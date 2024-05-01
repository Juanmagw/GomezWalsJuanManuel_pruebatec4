package com.juanmagw.PruebaTecnica4.repository;

import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFlightRepository extends JpaRepository<BookingFlight, Long> {
}
