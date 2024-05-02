package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.BookingRoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.repository.BookingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRoomService implements IBookingRoomService{

    @Autowired
    private BookingRoomRepository bookingRoomRepository;

    @Override
    public List<BookingRoomDTO> findAllActive(){
        return bookingRoomRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(this::getBookingRoomDTOFromBookingRoom).toList();
    }

    @Override
    public List<BookingRoomDTO> findAll() {
        return bookingRoomRepository.findAll().stream().map(this::getBookingRoomDTOFromBookingRoom).toList();
    }

    @Override
    public Double bookRoom(BookingRoom bookingRoom) {
        bookingRoom.setIsDeleted(false);
        bookingRoomRepository.save(bookingRoom);
        return bookingRoom.getRoom().getPrice();
    }

    @Override
    public BookingRoomDTO update(BookingRoomDTO bookingRoomDTO, Long id) {
        BookingRoom bookingRoomAux = bookingRoomRepository.findById(id).orElse(null);
        if (bookingRoomAux != null) {
            bookingRoomAux.setCode(bookingRoomDTO.getCode());
            bookingRoomAux.setStartDate(bookingRoomDTO.getStartDate());
            bookingRoomAux.setEndDate(bookingRoomDTO.getEndDate());
            bookingRoomAux.setPeople(bookingRoomDTO.getPeople());
            bookingRoomAux.setRoomType(bookingRoomDTO.getRoomType());
            bookingRoomAux.setClient(ClientService.getClientFromClientDTO(bookingRoomDTO.getClient()));
            bookingRoomAux.setRoom(RoomService.getRoomFromRoomDTO(bookingRoomDTO.getRoom()));
            return getBookingRoomDTOFromBookingRoom(bookingRoomRepository.save(bookingRoomAux));
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        BookingRoom bookingRoom = bookingRoomRepository.findById(id).orElse(null);
        if (bookingRoom != null) {
            bookingRoom.setIsDeleted(true);
            bookingRoomRepository.save(bookingRoom);
        }
    }

    @Override
    public BookingRoomDTO findById(Long id) {
        return getBookingRoomDTOFromBookingRoom(bookingRoomRepository.findById(id).orElse(null));
    }

    public BookingRoomDTO getBookingRoomDTOFromBookingRoom(BookingRoom bookingRoom){
        BookingRoomDTO bookingRoomDTO = new BookingRoomDTO();
        if(bookingRoom != null) {
            bookingRoomDTO.setCode(bookingRoom.getCode());
            bookingRoomDTO.setStartDate(bookingRoom.getStartDate());
            bookingRoomDTO.setEndDate(bookingRoom.getEndDate());
            bookingRoomDTO.setPeople(bookingRoom.getPeople());
            bookingRoomDTO.setRoomType(bookingRoom.getRoomType());
            bookingRoomDTO.setClient(ClientService.getClientDTOFromClient(bookingRoom.getClient()));
            bookingRoomDTO.setRoom(RoomService.getRoomDTOFromRoom(bookingRoom.getRoom()));
            return bookingRoomDTO;
        }else{
            return null;
        }
    }
}
