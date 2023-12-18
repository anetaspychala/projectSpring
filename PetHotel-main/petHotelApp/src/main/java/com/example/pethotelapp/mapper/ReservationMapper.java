package com.example.pethotelapp.mapper;
import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.dto.ReservationDto;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.model.AnimalModel;
import com.example.pethotelapp.model.ReservationModel;
import com.example.pethotelapp.model.RoomModel;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationMapper {
    public static ReservationDto toReservationDto(ReservationModel reservationModel) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setPrice(reservationModel.getPrice());
        reservationDto.setStartDate(reservationModel.getStartDate());
        reservationDto.setEndDate(reservationModel.getEndDate());
        reservationDto.setReservationStatus(reservationModel.getReservationStatus());
        reservationDto.setUser(reservationModel.getUser());

        return reservationDto;
    }

    public static ReservationModel toReservationModel(ReservationDto reservationDto) {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setPrice(reservationDto.getPrice());
        reservationModel.setStartDate(reservationDto.getStartDate());
        reservationModel.setEndDate(reservationDto.getEndDate());
        reservationModel.setReservationStatus(reservationDto.getReservationStatus());
        reservationModel.setUser(reservationDto.getUser());
        return reservationModel;
    }
}

//do dodania sa add animal i room