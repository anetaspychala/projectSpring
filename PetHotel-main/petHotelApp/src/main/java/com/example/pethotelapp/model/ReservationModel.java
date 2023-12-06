package com.example.pethotelapp.model;

import com.example.pethotelapp.enumType.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_number")
    private Long reservationNumber;

    @Column(name = "start_Date")
    private LocalDate startDate;

    @Column(name = "end_Date")
    private LocalDate endDate;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status")
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "user_id") // wiele leczen do jednego zwierzecia, JoinColumn, klucz obcy id zwierzecia
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "reservation_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<RoomModel> rooms;

    @ManyToMany
    @JoinTable(
            name = "reservation_animal",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private Set<AnimalModel> animals;
}
