package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.BookingFlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.repository.BookingFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingFlightService implements IBookingFlightService{

    @Autowired
    private BookingFlightRepository bookingFlightRepository;

    @Override
    public List<BookingFlightDTO> findAllActive(){
        return bookingFlightRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(this::getBookingFlightDTOFromBookingFlight).toList();
    }

    @Override
    public List<BookingFlightDTO> findAll() {
        return bookingFlightRepository.findAll().stream().map(this::getBookingFlightDTOFromBookingFlight).toList();
    }

    @Override
    public Double bookFlight(BookingFlight bookingFlight) {
        bookingFlightRepository.save(bookingFlight);
        return bookingFlight.getFlight().getTotalPrice();
    }

    @Override
    public BookingFlightDTO update(BookingFlightDTO bookingFlightDTO, Long id) {
        BookingFlight bookingFlightAux = bookingFlightRepository.findById(id).orElse(null);
        if (bookingFlightAux != null) {
            bookingFlightAux.setCode(bookingFlightDTO.getCode());
            bookingFlightAux.setStartDate(bookingFlightDTO.getStartDate());
            bookingFlightAux.setOrigin(bookingFlightDTO.getOrigin());
            bookingFlightAux.setDestination(bookingFlightDTO.getDestination());
            bookingFlightAux.setPeople(bookingFlightDTO.getPeople());
            bookingFlightAux.setFlight(FlightService.getFlightFromFlightDTO(bookingFlightDTO.getFlight()));
            bookingFlightAux.setClient(ClientService.getClientFromClientDTO(bookingFlightDTO.getClient()));
            return getBookingFlightDTOFromBookingFlight(bookingFlightRepository.save(bookingFlightAux));
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        BookingFlight bookingFlight = bookingFlightRepository.findById(id).orElse(null);
        if (bookingFlight != null) {
            bookingFlight.setIsDeleted(true);
            bookingFlightRepository.save(bookingFlight);
        }
    }

    @Override
    public BookingFlightDTO findById(Long id) {
        return getBookingFlightDTOFromBookingFlight(bookingFlightRepository.findById(id).orElse(null));
    }

    public BookingFlightDTO getBookingFlightDTOFromBookingFlight(BookingFlight bookingFlight){
        BookingFlightDTO bookingFlightDTO = new BookingFlightDTO();
        if (bookingFlight != null) {
            bookingFlightDTO.setCode(bookingFlight.getCode());
            bookingFlightDTO.setStartDate(bookingFlight.getStartDate());
            bookingFlightDTO.setOrigin(bookingFlight.getOrigin());
            bookingFlightDTO.setDestination(bookingFlight.getDestination());
            bookingFlightDTO.setPeople(bookingFlight.getPeople());
            bookingFlightDTO.setFlight(FlightService.getFlightDTOFromFlight(bookingFlight.getFlight()));
            bookingFlightDTO.setClient(ClientService.getClientDTOFromClient(bookingFlight.getClient()));
            return bookingFlightDTO;
        }else {
            return null;
        }
    }
}
