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
public class BookingRoomDTO {
    @NotNull(message = "Code cannot be null")
    private String code;
    @NotNull(message = "StartDate cannot be null")
    private LocalDate startDate;
    @NotNull(message = "EndDate cannot be null")
    private LocalDate EndDate;
    @NotNull(message = "People cannot be null")
    private Integer people;
    @NotNull(message = "SeatType cannot be null")
    private String seatType;
    @NotNull(message = "Client cannot be null")
    private ClientDTO client;
    @NotNull(message = "Room cannot be null")
    private RoomDTO room;
}
