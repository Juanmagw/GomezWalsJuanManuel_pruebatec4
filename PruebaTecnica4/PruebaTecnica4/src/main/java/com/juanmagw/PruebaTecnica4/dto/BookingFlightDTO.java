package com.juanmagw.PruebaTecnica4.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingFlightDTO {
    @NotNull(message = "Code cannot be null")
    private String code;
    @NotNull(message = "StartDate cannot be null")
    private LocalDate startDate;
    @NotNull(message = "Origin cannot be null")
    private String origin;
    @NotNull(message = "Destination cannot be null")
    private String destination;
    @NotNull(message = "People cannot be null")
    private Integer people;
    @NotNull(message = "Client cannot be null")
    private ClientDTO client;
    @NotNull(message = "Flight cannot be null")
    private FlightDTO flight;
}
