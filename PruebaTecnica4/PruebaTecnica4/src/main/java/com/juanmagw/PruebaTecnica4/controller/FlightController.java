package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.Flight;
import com.juanmagw.PruebaTecnica4.service.IFlightService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<FlightDTO>> findAllActive(){
        return ResponseEntity.ok(flightService.findAllActive());
    }

    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No flights found")
    })
    public ResponseEntity<List<FlightDTO>> findAll(){
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/dates-travel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No flights found")
    })
    public ResponseEntity<List<FlightDTO>> findFlightsByDatesOriginDestination(@RequestParam LocalDate originDate, @RequestParam LocalDate returnDate, @RequestParam String origin, @RequestParam String destination){
        return ResponseEntity.ok(flightService.findFlightsByDatesOriginDestination(originDate, returnDate, origin, destination));
    }

    //Autenticado
    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flight created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid flight data")
    })
    public ResponseEntity<Flight> save(@Valid @RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.save(flight));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flight updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid flight data"),
            @ApiResponse(responseCode = "404", description = "Flight with that id not found")
    })
    public ResponseEntity<FlightDTO> update(@Valid @RequestBody FlightDTO flightDTO, @PathVariable Long id) {
        return ResponseEntity.ok(flightService.update(flightDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flight deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Flight with that id not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        flightService.delete(id);
        return ResponseEntity.ok().build();
    }

    //No autenticado
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flight found successfully"),
            @ApiResponse(responseCode = "404", description = "Flight with that id not found")
    })
    public ResponseEntity<FlightDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.findById(id));
    }
}
