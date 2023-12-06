package com.example.pethotelapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Long phone;


    private String login;


    private String password;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<RoleModel> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //relacja 1 do wielu z AnimalModel, wlasciciel relacji
    private List<AnimalModel> animals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //relacja 1 do wielu z ReservationModel, wlasciciel relacji
    private List<ReservationModel> reservations;

}
