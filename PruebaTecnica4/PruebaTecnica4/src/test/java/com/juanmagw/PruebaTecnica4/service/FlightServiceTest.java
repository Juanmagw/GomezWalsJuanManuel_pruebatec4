package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.model.Flight;
import com.juanmagw.PruebaTecnica4.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testSave() {
        // Arrange
        Flight flight = new Flight();
        flight.setCode("FL123");
        // Assume that the repository will return the same flight when save is called
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        // Act
        Flight savedFlight = flightService.save(flight);

        // Assert
        assertEquals(flight.getCode(), savedFlight.getCode());
        verify(flightRepository, times(1)).save(flight);
    }

}
