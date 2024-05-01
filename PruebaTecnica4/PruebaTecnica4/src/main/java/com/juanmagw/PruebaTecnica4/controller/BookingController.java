package com.juanmagw.PruebaTecnica4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency/booking")
public class BookingController {

    @Autowired
    private IBookingFlightService bookingFlightService;

    @Autowired
    private IBookingRoomService bookingRoomService;


}
