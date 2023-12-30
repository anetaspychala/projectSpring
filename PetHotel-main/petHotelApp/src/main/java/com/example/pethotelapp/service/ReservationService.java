package com.example.pethotelapp.service;


import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.dto.ReservationDto;
import com.example.pethotelapp.mapper.AnimalMapper;
import com.example.pethotelapp.mapper.ReservationMapper;
import com.example.pethotelapp.model.AnimalModel;
import com.example.pethotelapp.model.ReservationModel;
import com.example.pethotelapp.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public ReservationDto addReservation(ReservationDto reservationDto) {
        try {
            ReservationModel reservationModel = ReservationMapper.toReservationModel(reservationDto);
            ReservationModel addReservation = reservationRepository.save(reservationModel);
            return ReservationMapper.toReservationDto(addReservation);
        } catch (Exception e) {
            log.error("Error adding reservation", e);
            throw new RuntimeException("Error adding reservation", e);
        }
    }
    public List<ReservationModel> getReservationList() {
    return reservationRepository.findAll();}

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public ReservationDto editReservation(Long id, ReservationDto updatedReservationDto) {
        Optional<ReservationModel> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()) {
            ReservationModel existingReservation = reservationOptional.get();
            existingReservation.setStartDate(updatedReservationDto.getStartDate());
            existingReservation.setEndDate(updatedReservationDto.getEndDate());
            existingReservation.setReservationStatus(updatedReservationDto.getReservationStatus());
            existingReservation.setPrice(updatedReservationDto.getPrice());
            ReservationModel updatedReservation = reservationRepository.save(existingReservation);
            return ReservationMapper.toReservationDto(updatedReservation);
        } else {
            throw new NoSuchElementException("Reservation with id " + id + " not found");
        }
    }
}
