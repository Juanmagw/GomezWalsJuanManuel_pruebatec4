package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.BookingFlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;

import java.util.List;

public interface IBookingFlightService {
    List<BookingFlightDTO> findAllActive();
    List<BookingFlightDTO> findAll();
    Double bookFlight(BookingFlight bookingFlight);
    BookingFlightDTO update(BookingFlightDTO bookingFlightDTO, Long id);
    void delete(Long id);
    BookingFlightDTO findById(Long id);
}
