package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {
    List<FlightDTO> findAllActive();
    List<FlightDTO> findAll();
    List<FlightDTO> findFlightsByDatesOriginDestination(LocalDate originDate, LocalDate returnDate, String origin, String destination);
    Flight save(Flight flight);
    FlightDTO update(FlightDTO flightDTO, Long id);
    void delete(Long id);
    FlightDTO findById(Long id);
}
