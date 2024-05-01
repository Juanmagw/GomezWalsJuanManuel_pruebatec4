package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> findAll();
    Room save(Room room);
    Room update(Room room, Long id);
    void delete(Long id);
    Room findById(Long id);
}
