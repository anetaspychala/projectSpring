package com.example.pethotelapp.service;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.mapper.RoomMapper;
import com.example.pethotelapp.model.RoomModel;
import com.example.pethotelapp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void saveEditRoom(RoomModel editRoom) {
        roomRepository.save(editRoom);
    }

    public void deleteRoom(Long id) {roomRepository.deleteById(id);
    }
}