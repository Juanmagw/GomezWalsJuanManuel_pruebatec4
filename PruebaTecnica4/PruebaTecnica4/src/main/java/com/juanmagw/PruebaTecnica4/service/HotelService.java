package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import com.juanmagw.PruebaTecnica4.model.Hotel;
import com.juanmagw.PruebaTecnica4.model.Room;
import com.juanmagw.PruebaTecnica4.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream().map(this::getHotelDTOFromHotel).collect(Collectors.toList());
    }

    @Override
    public List<RoomDTO> findRoomsByDatesArrival(LocalDate fromDate, LocalDate toDate, String destination) {
        List<HotelDTO> hotelDTOList = findAll().stream()
                .filter(hotel -> hotel.getPlace().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
        return hotelDTOList.stream().map(hotelDTO -> hotelDTO.getRoomList().stream()
                .filter(room -> room.getFromDate().isAfter(fromDate) && room.getToDate().isBefore(toDate))
                .map(this::getRoomDTOFromRoom)
                .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Double bookRoom(BookingRoom bookingRoom) {
        return bookingRoom.getRoom().getPrice();
    }

    @Override
    public Hotel save(Hotel hotel) {
        if (findById(hotel.getId()) == null) {
            hotel.setIsDeleted(false);
            return hotelRepository.save(hotel);
        }else{
            return null;
        }
    }

    @Override
    public Hotel update(Hotel hotel, Long id) {
        Hotel hotelAux = findById(id);
        if(hotelAux != null){
            hotelAux.setName(hotel.getName());
            hotelAux.setPlace(hotel.getPlace());
            return hotelRepository.save(hotelAux);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = findById(id);
        hotel.setIsDeleted(true);
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public HotelDTO getHotelDTOFromHotel(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setCode(hotel.getCode());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setPlace(hotel.getPlace());
        hotelDTO.setRoomList(hotel.getRoomList());
        return hotelDTO;
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
