package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;
import com.juanmagw.PruebaTecnica4.service.IRoomService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<RoomDTO>> findAllActive(){
        return ResponseEntity.ok(roomService.findAllActive());
    }

    //No autenticado
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all rooms found successfully"),
            @ApiResponse(responseCode = "404", description = "No rooms found")
    })
    public ResponseEntity<List<RoomDTO>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    //Autenticado
    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid room data")
    })
    public ResponseEntity<RoomDTO> save(@Valid @RequestBody Room room) {
        return ResponseEntity.ok(roomService.save(room));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid room data"),
            @ApiResponse(responseCode = "404", description = "Room with that id not found")
    })
    public ResponseEntity<RoomDTO> update(@Valid @RequestBody RoomDTO roomDTO, @PathVariable Long id) {
        return ResponseEntity.ok(roomService.update(roomDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Room with that id not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.ok().build();
    }

    //No autenticado
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room found successfully"),
            @ApiResponse(responseCode = "404", description = "Room with that id not found")
    })
    public ResponseEntity<RoomDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findById(id));
    }
}
