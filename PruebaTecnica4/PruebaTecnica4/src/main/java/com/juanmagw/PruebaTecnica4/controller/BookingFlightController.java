package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.BookingFlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.service.IBookingFlightService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/flight-booking")
public class BookingFlightController {

    @Autowired
    private IBookingFlightService bookingFlightService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<BookingFlightDTO>> findAllActive(){
        return ResponseEntity.ok(bookingFlightService.findAllActive());
    }

    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all bookings found successfully"),
            @ApiResponse(responseCode = "404", description = "No bookings found")
    })
    public ResponseEntity<List<BookingFlightDTO>> findAll() {
        return ResponseEntity.ok(bookingFlightService.findAll());
    }

    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid booking data")
    })
    public Double bookFlight(@Valid @RequestBody BookingFlight bookingFlight){
        return bookingFlightService.bookFlight(bookingFlight);
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid booking data"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found")
    })
    public ResponseEntity<BookingFlightDTO> update(@Valid @RequestBody BookingFlightDTO bookingFlightDTO, @PathVariable Long id) {
        return ResponseEntity.ok(bookingFlightService.update(bookingFlightDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingFlightService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking found successfully"),
            @ApiResponse(responseCode = "404", description = "Booking with that id not found")
    })
    public ResponseEntity<BookingFlightDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingFlightService.findById(id));
    }
}
