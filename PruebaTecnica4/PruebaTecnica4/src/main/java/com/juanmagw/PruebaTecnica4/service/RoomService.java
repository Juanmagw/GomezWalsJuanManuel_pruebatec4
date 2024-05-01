package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;
import com.juanmagw.PruebaTecnica4.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomDTO> findAll() {
        return roomRepository.findAll().stream().map(this::getRoomDTOFromRoom).collect(Collectors.toList());
    }

    @Override
    public Room save(Room room) {
        if (findById(room.getId()) == null) {
            room.setIsDeleted(false);
            return roomRepository.save(room);
        }else{
            return null;
        }
    }

    @Override
    public Room update(Room room, Long id) {
        Room roomAux = findById(id);
        if(roomAux != null) {
            roomAux.setCode(room.getCode());
            roomAux.setType(room.getType());
            roomAux.setMaxHostsNumber(room.getMaxHostsNumber());
            roomAux.setPrice(room.getPrice());
            roomAux.setFromDate(room.getFromDate());
            roomAux.setToDate(room.getToDate());
            roomAux.setHotel(room.getHotel());
            roomAux.setBookingRoomList(room.getBookingRoomList());
            return roomRepository.save(roomAux);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Room room = findById(id);
        room.setIsDeleted(true);
        roomRepository.save(room);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public RoomDTO getRoomDTOFromRoom(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setCode(room.getCode());
        roomDTO.setType(room.getType());
        roomDTO.setMaxHostsNumber(room.getMaxHostsNumber());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setFromDate(room.getFromDate());
        roomDTO.setToDate(room.getToDate());
        roomDTO.setHotel(room.getHotel());
        roomDTO.setBookingRoomList(room.getBookingRoomList());
        return roomDTO;
    }
}
