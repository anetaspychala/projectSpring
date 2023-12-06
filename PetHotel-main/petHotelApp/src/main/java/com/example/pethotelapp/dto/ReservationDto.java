package com.example.pethotelapp.dto;

import com.example.pethotelapp.enumType.ReservationStatus;

import com.example.pethotelapp.model.UserModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ReservationDto {

    private Long id;

    private Long reservationNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal price;

    private ReservationStatus reservationStatus;

    private UserModel user;

    private Set<Long> roomIds;

    private Set<Long> animalIds;
}
