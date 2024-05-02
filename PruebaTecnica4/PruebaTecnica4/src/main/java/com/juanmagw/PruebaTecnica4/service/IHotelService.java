package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    List<HotelDTO> findAllActive();
    List<HotelDTO> findAll();
    List<RoomDTO> findRoomsByDatesArrival(LocalDate fromDate, LocalDate toDate, String destination);
    HotelDTO save(Hotel hotel);
    HotelDTO update(HotelDTO hotelDTO, Long id);
    void delete(Long id);
    HotelDTO findById(Long id);
}
