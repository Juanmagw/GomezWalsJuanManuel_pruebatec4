package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(nullable = false)
    @NotNull(message = "Surname cannot be null")
    private String surname;
    @Column(nullable = false)
    @NotNull(message = "Email cannot be null")
    private String email;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "client")
    private List<BookingFlight> bookingFlights;
    @OneToMany(mappedBy = "client")
    private List<BookingRoom> bookingRooms;
}
