package com.example.pethotelapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AnimalDto {
    private Long id;
    private String type;
    private Integer weight;
    private String name;
    private String sex;
   // private Long ownerId; do odblokowania przekazywanie id
    //private Set<TreatmentModel> treatments;
    //private Set<Long> reservationIds;
}
