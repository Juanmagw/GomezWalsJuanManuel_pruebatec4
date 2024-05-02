package com.juanmagw.PruebaTecnica4.dto;

import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Code cannot be null")
    private String code;
    @NotNull(message = "Origin cannot be null")
    private String origin;
    @NotNull(message = "Destination cannot be null")
    private String destination;
    @NotNull(message = "SeatType cannot be null")
    private String seatType;
    @NotNull(message = "OriginDate cannot be null")
    private LocalDate originDate;
    @NotNull(message = "ReturnDate cannot be null")
    private LocalDate returnDate;
    @NotNull(message = "AvailableSeats cannot be null")
    private Integer availableSeats;
    @NotNull(message = "TotalPrice cannot be null")
    private Double totalPrice;
}
