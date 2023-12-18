package com.example.pethotelapp.mapper;

import com.example.pethotelapp.dto.ReservationDto;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.model.RoomModel;

public class RoomMapper {

    public static RoomDto toRoomDto(RoomModel roomModel){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(roomModel.getId());
        roomDto.setName(roomModel.getName());
        roomDto.setStandard(roomModel.getStandard());
        roomDto.setAnimalSize(roomModel.getAnimalSize());
        roomDto.setIsActive((roomModel.getActive()));
        return roomDto;
    }
    public static RoomModel toRoomModel(RoomDto roomDto){
        RoomModel roomModel = new RoomModel();
        roomModel.setId(roomDto.getId());
        roomModel.setName(roomDto.getName());
        roomModel.setStandard(roomDto.getStandard());
        roomModel.setAnimalSize(roomDto.getAnimalSize());
        roomModel.setActive(roomDto.getIsActive());
        return roomModel;
    }
}
