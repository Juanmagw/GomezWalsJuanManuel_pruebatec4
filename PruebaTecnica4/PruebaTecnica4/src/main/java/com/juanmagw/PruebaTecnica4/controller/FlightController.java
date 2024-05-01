package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.FlightDTO;
import com.juanmagw.PruebaTecnica4.model.BookingFlight;
import com.juanmagw.PruebaTecnica4.model.Flight;
import com.juanmagw.PruebaTecnica4.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;

    @GetMapping("/all")
    public List<FlightDTO> findAll(){
        return flightService.findAll();
    }

    @GetMapping("/dates-travel")
    public List<FlightDTO> findFlightsByDatesOriginDestination(@RequestParam LocalDate originDate, @RequestParam LocalDate returnDate, @RequestParam String origin, @RequestParam String destination){
        return flightService.findFlightsByDatesOriginDestination(originDate, returnDate, origin, destination);
    }

    @PostMapping("/flight-booking/new")
    public Double bookFlight(@RequestBody BookingFlight bookingFlight){
        return flightService.bookFlight(bookingFlight);
    }

    //Autenticado
    @PostMapping("/new")
    public Flight save(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping("/edit/{id}")
    public Flight update(@RequestBody Flight flight, @PathVariable Long id) {
        return flightService.update(flight, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }

    //No autenticado
    @GetMapping("/{id}") //→ Hotel en particular
    public Flight findById(@PathVariable Long id) {
        return flightService.findById(id);
    }
}
