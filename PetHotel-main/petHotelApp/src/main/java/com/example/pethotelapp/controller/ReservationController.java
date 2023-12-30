package com.example.pethotelapp.controller;

import com.example.pethotelapp.dto.ReservationDto;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.model.ReservationModel;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/adminpanel")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<ReservationModel> getReservationList(ReservationModel reservation){
        List<ReservationModel> reservationList = reservationService.getReservationList();
        return reservationList;
    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting reservation");
        }
    }
    @PutMapping("/editReservation/{id}")
    public ResponseEntity<?> editReservation(@PathVariable Long id, @RequestBody ReservationDto updatedReservationDto) {
        try {
            ReservationDto editedReservation = reservationService.editReservation(id, updatedReservationDto);
            return ResponseEntity.ok(editedReservation);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing reservation");
        }
    }
}
