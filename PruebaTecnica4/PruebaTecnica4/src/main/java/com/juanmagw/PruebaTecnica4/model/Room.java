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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Code cannot be null")
    private String code;
    @Column(nullable = false)
    @NotNull(message = "Type cannot be null")
    private String type;
    @Column(nullable = false)
    @NotNull(message = "MaxHostsNumber cannot be null")
    private Integer maxHostsNumber;
    @Column(nullable = false)
    @NotNull(message = "Price cannot be null")
    private Double price;
    @Column(nullable = false)
    @NotNull(message = "FromDate cannot be null")
    private LocalDate fromDate;
    @Column(nullable = false)
    @NotNull(message = "ToDate cannot be null")
    private LocalDate toDate;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @NotNull(message = "Hotel cannot be null")
    private Hotel hotel;
    @OneToMany(mappedBy = "room")
    List<BookingRoom> bookingRoomList;
}
