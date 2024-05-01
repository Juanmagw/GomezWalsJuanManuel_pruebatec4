package com.juanmagw.PruebaTecnica4.dto;

import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String name;
    private String surname;
    private String email;
    private List<BookingFlight> bookingFlights;
    private List<BookingRoom> bookingRooms;
}
