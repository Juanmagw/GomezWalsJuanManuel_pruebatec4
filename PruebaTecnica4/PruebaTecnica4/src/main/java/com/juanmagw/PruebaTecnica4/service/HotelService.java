package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.HotelDTO;
import com.juanmagw.PruebaTecnica4.dto.RoomDTO;
import com.juanmagw.PruebaTecnica4.model.Hotel;
import com.juanmagw.PruebaTecnica4.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> findAllActive(){
        return hotelRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(this::getHotelDTOFromHotel).toList();
    }

    @Override
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream().map(this::getHotelDTOFromHotel).toList();
    }

    @Override
    public List<RoomDTO> findRoomsByDatesArrival(LocalDate fromDate, LocalDate toDate, String destination) {
        return hotelRepository.findAll().stream()
                .filter(hotel -> hotel.getPlace().equals(destination))
                .flatMap(hotel -> hotel.getRoomList().stream()
                        .filter(room -> room.getFromDate().isAfter(fromDate) && room.getToDate().isBefore(toDate))
                        .map(RoomService::getRoomDTOFromRoom))
                .toList();
    }

    @Override
    public HotelDTO save(Hotel hotel) {
        if (findById(hotel.getId()) == null) {
            hotel.setIsDeleted(false);
            return getHotelDTOFromHotel(hotelRepository.save(hotel));
        }else{
            return null;
        }
    }

    @Override
    public HotelDTO update(HotelDTO hotelDTO, Long id) {
        Hotel hotelAux = hotelRepository.findById(id).orElse(null);
        if(hotelAux != null){
            hotelAux.setCode(hotelDTO.getCode());
            hotelAux.setName(hotelDTO.getName());
            hotelAux.setPlace(hotelDTO.getPlace());
            return getHotelDTOFromHotel(hotelRepository.save(hotelAux));
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            hotel.setIsDeleted(true);
            hotelRepository.save(hotel);
        }
    }

    @Override
    public HotelDTO findById(Long id) {
        return getHotelDTOFromHotel(hotelRepository.findById(id).orElse(null));
    }

    public HotelDTO getHotelDTOFromHotel(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null){
            hotelDTO.setCode(hotel.getCode());
            hotelDTO.setName(hotel.getName());
            hotelDTO.setPlace(hotel.getPlace());
            return hotelDTO;
        }else {
            return null;
        }
    }

    public static Hotel getHotelFromHotelDTO(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        if (hotelDTO != null){
            hotel.setCode(hotelDTO.getCode());
            hotel.setName(hotelDTO.getName());
            hotel.setPlace(hotelDTO.getPlace());
            return hotel;
        }else{
            return null;
        }
    }
}
