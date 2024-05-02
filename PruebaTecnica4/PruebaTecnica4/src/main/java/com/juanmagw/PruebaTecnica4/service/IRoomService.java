package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> findAllActive();
    List<RoomDTO> findAll();
    RoomDTO save(Room room);
    RoomDTO update(RoomDTO roomDTO, Long id);
    void delete(Long id);
    RoomDTO findById(Long id);
}
