package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
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
@Entity
public class BookingFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Code cannot be null")
    private String code;
    @Column(unique = true, nullable = false)
    @NotNull(message = "StartDate cannot be null")
    private LocalDate startDate;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Origin cannot be null")
    private String origin;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Destination cannot be null")
    private String destination;
    @Column(unique = true, nullable = false)
    @NotNull(message = "People cannot be null")
    private Integer people;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull(message = "Client cannot be null")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    @NotNull(message = "Flight cannot be null")
    private Flight flight;
}
