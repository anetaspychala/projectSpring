package com.example.pethotelapp.controller;

import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.dto.ReservationDto;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.model.RoleModel;
import com.example.pethotelapp.service.AnimalService;
import com.example.pethotelapp.service.ReservationService;
import com.example.pethotelapp.service.RoomService;
import com.example.pethotelapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/userpanel")
public class UserPanel {
    private final AnimalService animalService;
    private final ReservationService reservationService;
    private final RoomService roomService;
    private final UserService userService;
    @PostMapping("/addRoom")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
        try {
            RoomDto addRoom = roomService.addRoom(roomDto);
            return ResponseEntity.ok(addRoom);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/addReservation")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationDto reservationDto) {
        try {
            ReservationDto addReservation = reservationService.addReservation(reservationDto);
            return ResponseEntity.ok(addReservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/addAnimal")
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody AnimalDto animalDto) {
        try {
            AnimalDto addAnimal = animalService.addAnimal(animalDto);
            return ResponseEntity.ok(addAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        try {
            UserDto addUser = userService.addUser(userDto);
            return ResponseEntity.ok(addUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
