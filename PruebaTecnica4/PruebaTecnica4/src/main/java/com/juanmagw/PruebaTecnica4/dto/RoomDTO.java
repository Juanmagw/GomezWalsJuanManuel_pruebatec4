package com.juanmagw.PruebaTecnica4.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    @NotNull(message = "Code cannot be null")
    private String code;
    @NotNull(message = "Type cannot be null")
    private String type;
    @NotNull(message = "MaxHostsNumber cannot be null")
    private Integer maxHostsNumber;
    @NotNull(message = "Price cannot be null")
    private Double price;
    @NotNull(message = "FromDate cannot be null")
    private LocalDate fromDate;
    @NotNull(message = "ToDate cannot be null")
    private LocalDate toDate;
    @NotNull(message = "Hotel cannot be null")
    private HotelDTO hotel;
}
