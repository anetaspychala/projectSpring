package com.example.pethotelapp.dto;

import com.example.pethotelapp.enumType.Sex;
import com.example.pethotelapp.model.TreatmentModel;
import lombok.Data;

import java.util.Set;

@Data
public class AnimalDto {
    private Long id;
    private String type;
    private Integer weight;
    private String name;
    private Sex sex;
    //private Long ownerId;
    //private Set<TreatmentModel> treatments;
    //private Set<Long> reservationIds;
}
