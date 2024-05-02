package com.juanmagw.PruebaTecnica4.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    @NotNull(message = "Code cannot be null")
    private String code;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Place cannot be null")
    private String place;
}
