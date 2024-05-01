package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
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
    private String code;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private String seatType;
    @Column(nullable = false)
    private LocalDate originDate;
    @Column(nullable = false)
    private LocalDate returnDate;
    @Column(nullable = false)
    private Integer availableSeats;
    @Column(nullable = false)
    private Double totalPrice;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "flight")
    private List<BookingFlight> bookingFlightList;
}
