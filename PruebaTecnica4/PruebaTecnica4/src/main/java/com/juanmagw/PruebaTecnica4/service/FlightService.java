package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.model.Flight;
import com.juanmagw.PruebaTecnica4.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream().map(this::getFlightDTOFromFlight).collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> findFlightsByDatesOriginDestination(LocalDate originDate, LocalDate returnDate, String origin, String destination) {
        return findAll().stream().filter(flightDTO -> flightDTO.getOrigin().equals(origin) && flightDTO.getDestination().equals(destination) && flightDTO.getOriginDate().equals(originDate) && flightDTO.getReturnDate().equals(returnDate)).collect(Collectors.toList());
    }

    @Override
    public Double bookFlight(BookingFlight bookingFlight) {
        return bookingFlight.getFlight().getTotalPrice();
    }

    @Override
    public Flight save(Flight flight) {
        if (findById(flight.getId()) == null) {
            flight.setIsDeleted(false);
            return flightRepository.save(flight);
        }else{
           return null;
        }
    }

    @Override
    public Flight update(Flight flight, Long id) {
        Flight flightAux = findById(id);
        if (flightAux != null) {
            flightAux.setCode(flight.getCode());
            flightAux.setOrigin(flight.getOrigin());
            flightAux.setDestination(flight.getDestination());
            flightAux.setSeatType(flight.getSeatType());
            flightAux.setTotalPrice(flight.getTotalPrice());
            flightAux.setOriginDate(flight.getOriginDate());
            flightAux.setReturnDate(flight.getReturnDate());
            flightAux.setIsDeleted(flight.getIsDeleted());
            return flightRepository.save(flightAux);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Flight flight = findById(id);
        if (flight != null) {
            flight.setIsDeleted(true);
            flightRepository.save(flight);
        }
    }

    @Override
    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public FlightDTO getFlightDTOFromFlight(Flight flight){
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setCode(flight.getCode());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setSeatType(flight.getSeatType());
        flightDTO.setAvailableSeats(flight.getAvailableSeats());
        flightDTO.setTotalPrice(flight.getTotalPrice());
        flightDTO.setOriginDate(flight.getOriginDate());
        flightDTO.setReturnDate(flight.getReturnDate());
        flightDTO.setBookingFlightList(flight.getBookingFlightList());
        return flightDTO;
    }
}
