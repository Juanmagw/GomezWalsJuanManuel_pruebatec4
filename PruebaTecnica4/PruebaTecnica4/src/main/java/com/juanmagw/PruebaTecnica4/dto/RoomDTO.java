package com.juanmagw.PruebaTecnica4.dto;

import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.model.Hotel;
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
public class RoomDTO {
    private String code;
    private String type;
    private Integer maxHostsNumber;
    private Double price;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Hotel hotel;
    List<BookingRoom> bookingRoomList;
}
