package com.example.pethotelapp.dto;

import lombok.Data;


@Data
public class TreatmentDto {

    private Long id;

    private String description;

    private Integer price;

    private Long animalId;

}
