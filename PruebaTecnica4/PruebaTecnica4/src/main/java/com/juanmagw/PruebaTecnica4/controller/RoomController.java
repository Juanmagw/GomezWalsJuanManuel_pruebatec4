package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;
import com.juanmagw.PruebaTecnica4.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    //No autenticado
    @GetMapping("/all")
    public List<RoomDTO> getRooms() {
        return roomService.findAll();
    }

    //Autenticado
    @PostMapping("/new")
    public Room save(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PutMapping("/edit/{id}")
    public Room update(@RequestBody Room room, @PathVariable Long id) {
        return roomService.update(room, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

    //No autenticado
    @GetMapping("/{id}") //→ Hotel en particular
    public Room findById(@PathVariable Long id) {
        return roomService.findById(id);
    }
}
