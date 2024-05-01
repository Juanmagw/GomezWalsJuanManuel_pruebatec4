package com.juanmagw.PruebaTecnica4.dto;

import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private String code;
    private String origin;
    private String destination;
    private String seatType;
    private LocalDate originDate;
    private LocalDate returnDate;
    private Integer availableSeats;
    private Double totalPrice;
    private List<BookingFlight> bookingFlightList;
}
