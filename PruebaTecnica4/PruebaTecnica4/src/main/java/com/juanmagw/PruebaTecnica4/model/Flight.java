package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
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
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Code cannot be null")
    private String code;
    @Column(nullable = false)
    @NotNull(message = "Origin cannot be null")
    private String origin;
    @Column(nullable = false)
    @NotNull(message = "Destination cannot be null")
    private String destination;
    @Column(nullable = false)
    @NotNull(message = "SeatType cannot be null")
    private String seatType;
    @Column(nullable = false)
    @NotNull(message = "OriginDate cannot be null")
    private LocalDate originDate;
    @Column(nullable = false)
    @NotNull(message = "RetunrDate cannot be null")
    private LocalDate returnDate;
    @Column(nullable = false)
    @NotNull(message = "AvailableSeats cannot be null")
    private Integer availableSeats;
    @Column(nullable = false)
    @NotNull(message = "TotalPrice cannot be null")
    private Double totalPrice;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "flight")
    private List<BookingFlight> bookingFlightList;
}
