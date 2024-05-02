package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.BookingRoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.service.IBookingRoomService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/room-booking")
public class BookingRoomController {

    @Autowired
    private IBookingRoomService bookingRoomService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<BookingRoomDTO>> findAllActive(){
        return ResponseEntity.ok(bookingRoomService.findAllActive());
    }

    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all bookings found successfully"),
            @ApiResponse(responseCode = "404", description = "No bookings found"),
    })
    public ResponseEntity<List<BookingRoomDTO>> findAll() {
        return ResponseEntity.ok(bookingRoomService.findAll());
    }

    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid booking data"),
    })
    public ResponseEntity<Double> bookRoom(@Valid @RequestBody BookingRoom bookingRoom){
        return ResponseEntity.ok(bookingRoomService.bookRoom(bookingRoom));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid booking data"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found"),
    })
    public ResponseEntity<BookingRoomDTO> update(@Valid @RequestBody BookingRoomDTO bookingRoomDTO, @PathVariable Long id) {
        return ResponseEntity.ok(bookingRoomService.update(bookingRoomDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found"),
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingRoomService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking found successfully"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found"),
    })
    public ResponseEntity<BookingRoomDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingRoomService.findById(id));
    }
}
