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
public class BookingRoom {
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
    @NotNull(message = "EndDate cannot be null")
    private LocalDate EndDate;
    @Column(unique = true, nullable = false)
    @NotNull(message = "People cannot be null")
    private Integer people;
    @Column(nullable = false)
    @NotNull(message = "SeatType cannot be null")
    private String seatType;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull(message = "Client cannot be null")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "room_id")
    @NotNull(message = "Room cannot be null")
    private Room room;
}
