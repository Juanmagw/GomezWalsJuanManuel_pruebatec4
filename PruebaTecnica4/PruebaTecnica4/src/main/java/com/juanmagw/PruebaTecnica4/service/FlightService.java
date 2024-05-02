package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.Flight;
import com.juanmagw.PruebaTecnica4.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightDTO> findAllActive(){
        return flightRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(FlightService::getFlightDTOFromFlight).toList();
    }

    @Override
    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream().map(FlightService::getFlightDTOFromFlight).toList();
    }

    @Override
    public List<FlightDTO> findFlightsByDatesOriginDestination(LocalDate originDate, LocalDate returnDate, String origin, String destination) {
        return findAll().stream().filter(flightDTO -> flightDTO.getOrigin().equals(origin) && flightDTO.getDestination().equals(destination) && flightDTO.getOriginDate().equals(originDate) && flightDTO.getReturnDate().equals(returnDate)).toList();
    }

    @Override
    public Flight save(Flight flight) {
            flight.setIsDeleted(false);
            return flightRepository.save(flight);
    }

    @Override
    public FlightDTO update(FlightDTO flightDTO, Long id) {
        Flight flightAux = flightRepository.findById(id).orElse(null);
        if (flightAux != null) {
            flightAux.setCode(flightDTO.getCode());
            flightAux.setOrigin(flightDTO.getOrigin());
            flightAux.setDestination(flightDTO.getDestination());
            flightAux.setSeatType(flightDTO.getSeatType());
            flightAux.setTotalPrice(flightDTO.getTotalPrice());
            flightAux.setOriginDate(flightDTO.getOriginDate());
            flightAux.setReturnDate(flightDTO.getReturnDate());
            return getFlightDTOFromFlight(flightRepository.save(flightAux));
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight != null) {
            flight.setIsDeleted(true);
            flightRepository.save(flight);
        }
    }

    @Override
    public FlightDTO findById(Long id) {
        return getFlightDTOFromFlight(flightRepository.findById(id).orElse(null));
    }

    public static FlightDTO getFlightDTOFromFlight(Flight flight){
        FlightDTO flightDTO = new FlightDTO();
        if (flight != null){
            flightDTO.setCode(flight.getCode());
            flightDTO.setOrigin(flight.getOrigin());
            flightDTO.setDestination(flight.getDestination());
            flightDTO.setSeatType(flight.getSeatType());
            flightDTO.setAvailableSeats(flight.getAvailableSeats());
            flightDTO.setTotalPrice(flight.getTotalPrice());
            flightDTO.setOriginDate(flight.getOriginDate());
            flightDTO.setReturnDate(flight.getReturnDate());
            return flightDTO;
        }else{
            return null;
        }

    }

    public static Flight getFlightFromFlightDTO(FlightDTO flightDTO){
        Flight flight = new Flight();
        if (flightDTO != null){
            flight.setCode(flightDTO.getCode());
            flight.setOrigin(flightDTO.getOrigin());
            flight.setDestination(flightDTO.getDestination());
            flight.setSeatType(flightDTO.getSeatType());
            flight.setAvailableSeats(flightDTO.getAvailableSeats());
            flight.setTotalPrice(flightDTO.getTotalPrice());
            flight.setOriginDate(flightDTO.getOriginDate());
            flight.setReturnDate(flightDTO.getReturnDate());
            return flight;
        }else{
            return null;
        }
    }
}
