package com.juanmagw.PruebaTecnica4.dto;

import com.juanmagw.PruebaTecnica4.model.Client;
import com.juanmagw.PruebaTecnica4.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRoomDTO {
    private String code;
    private Client client;
    private Room room;
}
