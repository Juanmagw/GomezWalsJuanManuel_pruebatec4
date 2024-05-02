package com.juanmagw.PruebaTecnica4.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Surname cannot be null")
    private String surname;
    @NotNull(message = "Email cannot be null")
    private String email;
}
