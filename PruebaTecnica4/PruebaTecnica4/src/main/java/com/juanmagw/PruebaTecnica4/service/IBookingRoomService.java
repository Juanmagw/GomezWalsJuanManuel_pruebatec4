package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.BookingRoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;

import java.util.List;

public interface IBookingRoomService {
    List<BookingRoomDTO> findAllActive();
    List<BookingRoomDTO> findAll();
    Double bookRoom(BookingRoom bookingRoom);
    BookingRoomDTO update(BookingRoomDTO bookingRoomDTO, Long id);
    void delete(Long id);
    BookingRoomDTO findById(Long id);
}
