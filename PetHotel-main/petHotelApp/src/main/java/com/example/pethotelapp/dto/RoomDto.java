package com.example.pethotelapp.dto;

import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class RoomDto {

    private Long id;

    private String name;

    private String standard;

    private Integer animalSize;

    private String isActive;

    //private Set<Long> reservationIds;
}
