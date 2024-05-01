package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {
    List<FlightDTO> findAll();
    List<FlightDTO> findFlightsByDatesOriginDestination(LocalDate originDate, LocalDate returnDate, String origin, String destination);
    Flight save(Flight flight);
    Flight update(Flight flight, Long id);
    void delete(Long id);
    Flight findById(Long id);
}
