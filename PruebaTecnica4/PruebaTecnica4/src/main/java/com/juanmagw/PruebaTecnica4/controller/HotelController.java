package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Hotel;
import com.juanmagw.PruebaTecnica4.service.IHotelService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<HotelDTO>> findAllActive(){
        return ResponseEntity.ok(hotelService.findAllActive());
    }

    //No autenticado
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all hotels found successfully"),
            @ApiResponse(responseCode = "404", description = "No hotels found")
    })
    public ResponseEntity<List<HotelDTO>> findAll() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/rooms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of rooms found successfully"),
            @ApiResponse(responseCode = "404", description = "No rooms found")
    })
    public ResponseEntity<List<RoomDTO>> findRoomsByDatesDestination(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam String destination) {
        return ResponseEntity.ok(hotelService.findRoomsByDatesArrival(fromDate, toDate, destination));
    }

    //Autenticado
    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid hotel data")
    })
    public ResponseEntity<HotelDTO> save(@Valid @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid hotel data"),
            @ApiResponse(responseCode = "404", description = "Hotel with that id not found")
    })
    public ResponseEntity<HotelDTO> update(@Valid @RequestBody HotelDTO hotelDTO, @PathVariable Long id) {
        return ResponseEntity.ok(hotelService.update(hotelDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Hotel with that id not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.ok().build();
    }

    //No autenticado
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel found successfully"),
            @ApiResponse(responseCode = "404", description = "Hotel with that id not found")
    })
    public ResponseEntity<HotelDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }
}
