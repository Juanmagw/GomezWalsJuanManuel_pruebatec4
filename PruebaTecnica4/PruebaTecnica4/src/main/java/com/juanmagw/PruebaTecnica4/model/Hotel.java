package com.juanmagw.PruebaTecnica4.model;

import jakarta.persistence.*;
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
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Code cannot be null")
    private String code;
    @Column(nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(nullable = false)
    @NotNull(message = "Place cannot be null")
    private String place;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "hotel")
    private List<Room> roomList;
}
