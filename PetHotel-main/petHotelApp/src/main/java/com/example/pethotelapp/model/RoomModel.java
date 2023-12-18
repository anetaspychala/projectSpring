package com.example.pethotelapp.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="room_model")
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "standard")
    private String standard;

    @Column(name = "animal_size")
    private Integer animalSize;

    @Column(name = "is_active")
    private String active;

    @ManyToMany(mappedBy = "rooms")
    private Set<ReservationModel> reservations;

}
