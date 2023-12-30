package com.example.pethotelapp.service;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.mapper.RoomMapper;
import com.example.pethotelapp.model.RoomModel;
import com.example.pethotelapp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDto addRoom(RoomDto roomDto) {
        try {
            RoomModel roomModel = RoomMapper.toRoomModel(roomDto);
            RoomModel addRoom = roomRepository.save(roomModel);
            return RoomMapper.toRoomDto(addRoom);
        } catch (Exception e) {
            log.error("Error adding reservation", e);
            throw new RuntimeException("Error adding reservation", e);
        }
    }


    public List<RoomModel> getRoomList() {
        return roomRepository.findAll();
    }

    public RoomModel getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }



    public void deleteRoom(Long id) {roomRepository.deleteById(id);
    }


    public RoomDto editRoom(Long id, RoomDto updatedRoomDto) {
        Optional<RoomModel> roomOptional = roomRepository.findById(id);

        if (roomOptional.isPresent()) {
            RoomModel existingRoom = roomOptional.get();
            existingRoom.setName(updatedRoomDto.getName());
            existingRoom.setStandard(updatedRoomDto.getStandard());
            existingRoom.setAnimalSize(updatedRoomDto.getAnimalSize());
            existingRoom.setActive(updatedRoomDto.getIsActive());
            RoomModel updatedRoom = roomRepository.save(existingRoom);
            return RoomMapper.toRoomDto(updatedRoom);
        } else {
            throw new NoSuchElementException("Room with id " + id + " not found");
        }
    }

}
