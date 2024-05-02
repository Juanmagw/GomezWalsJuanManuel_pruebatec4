package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Room;
import com.juanmagw.PruebaTecnica4.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomDTO> findAllActive(){
        return roomRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(RoomService::getRoomDTOFromRoom).toList();
    }

    @Override
    public List<RoomDTO> findAll() {
        return roomRepository.findAll().stream().map(RoomService::getRoomDTOFromRoom).toList();
    }

    @Override
    public RoomDTO save(Room room) {
        if (findById(room.getId()) == null) {
            room.setIsDeleted(false);
            return RoomService.getRoomDTOFromRoom(roomRepository.save(room));
        }else{
            return null;
        }
    }

    @Override
    public RoomDTO update(RoomDTO roomDTO, Long id) {
        Room roomAux = roomRepository.findById(id).orElse(null);
        if(roomAux != null) {
            roomAux.setCode(roomDTO.getCode());
            roomAux.setType(roomDTO.getType());
            roomAux.setMaxHostsNumber(roomDTO.getMaxHostsNumber());
            roomAux.setPrice(roomDTO.getPrice());
            roomAux.setFromDate(roomDTO.getFromDate());
            roomAux.setToDate(roomDTO.getToDate());
            roomAux.setHotel(HotelService.getHotelFromHotelDTO(roomDTO.getHotel()));
            return RoomService.getRoomDTOFromRoom(roomRepository.save(roomAux));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null) {
            room.setIsDeleted(true);
            roomRepository.save(room);
        }
    }

    @Override
    public RoomDTO findById(Long id) {
        return RoomService.getRoomDTOFromRoom(roomRepository.findById(id).orElse(null));
    }

    public static Room getRoomFromRoomDTO(RoomDTO roomDTO){
        Room room = new Room();
        if (roomDTO != null) {
            room.setCode(roomDTO.getCode());
            room.setType(roomDTO.getType());
            room.setMaxHostsNumber(roomDTO.getMaxHostsNumber());
            room.setPrice(roomDTO.getPrice());
            room.setFromDate(roomDTO.getFromDate());
            room.setToDate(roomDTO.getToDate());
            return room;
        }else{
            return null;
        }
    }

    public static RoomDTO getRoomDTOFromRoom(Room room){
        RoomDTO roomDTO = new RoomDTO();
        if (room != null) {
            roomDTO.setCode(room.getCode());
            roomDTO.setType(room.getType());
            roomDTO.setMaxHostsNumber(room.getMaxHostsNumber());
            roomDTO.setPrice(room.getPrice());
            roomDTO.setFromDate(room.getFromDate());
            roomDTO.setToDate(room.getToDate());
            return roomDTO;
        }else{
            return null;
        }
    }
}
