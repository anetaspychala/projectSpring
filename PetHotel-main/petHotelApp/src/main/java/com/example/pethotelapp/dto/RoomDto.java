package com.example.pethotelapp.dto;

import com.example.pethotelapp.enumType.Standard;
import com.example.pethotelapp.model.ReservationModel;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class RoomDto {

    private Long id;

    private String name;

    private Standard standard;

    private List<Integer> animalSize;

    private Boolean active;

    private Set<Long> reservationIds;
}
