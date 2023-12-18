package com.example.pethotelapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="animal_model")
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private Integer weight; //Beata enum do dyskusji

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @ManyToOne
    private UserModel user;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private Set<TreatmentModel> treatments;

    @ManyToMany(mappedBy = "animals")
    private Set<ReservationModel> reservations;
}

