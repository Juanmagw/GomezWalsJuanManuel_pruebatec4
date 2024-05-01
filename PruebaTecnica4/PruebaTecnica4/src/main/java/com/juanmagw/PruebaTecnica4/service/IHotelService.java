package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    List<HotelDTO> findAll();
    List<RoomDTO> findRoomsByDatesArrival(LocalDate fromDate, LocalDate toDate, String destination);
    Double bookRoom(BookingRoom bookingRoom);
    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel, Long id);
    void delete(Long id);
    Hotel findById(Long id);
}
