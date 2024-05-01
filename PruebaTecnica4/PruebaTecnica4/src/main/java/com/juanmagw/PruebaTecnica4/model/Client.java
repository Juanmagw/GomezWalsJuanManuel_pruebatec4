package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
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
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean isDeleted;
    @OneToMany(mappedBy = "client")
    private List<BookingFlight> bookingFlights;
    @OneToMany(mappedBy = "client")
    private List<BookingRoom> bookingRooms;
}
