package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.model.Hotel;
import com.juanmagw.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    //No autenticado
    @GetMapping("/all")
    public List<HotelDTO> getHotels() {
        return hotelService.findAll();
    }

    @GetMapping("/rooms")
    public List<RoomDTO> findRoomsByDatesDestination(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam String destination) {
        return hotelService.findRoomsByDatesArrival(fromDate, toDate, destination);
    }

    @PostMapping("/room-booking/new")
    public Double bookRoom(@RequestBody BookingRoom bookingRoom){
        return hotelService.bookRoom(bookingRoom);
    }

    //Autenticado
    @PostMapping("/new")
    public Hotel save(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @PutMapping("/edit/{id}")
    public Hotel update(@RequestBody Hotel hotel, @PathVariable Long id) {
        return hotelService.update(hotel, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }

    //No autenticado
    @GetMapping("/{id}") //→ Hotel en particular
    public Hotel findById(@PathVariable Long id) {
        return hotelService.findById(id);
    }
}
