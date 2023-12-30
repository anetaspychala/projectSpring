package com.example.pethotelapp.controller;

import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.model.ReservationModel;
import com.example.pethotelapp.model.RoomModel;
import com.example.pethotelapp.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/adminpanel")
public class RoomController {

    private final RoomService roomService;



    @GetMapping("/rooms")
    public List<RoomModel> getRoomList(RoomModel room){
        List<RoomModel> roomList = roomService.getRoomList();
        return roomList;
    }

    @PutMapping("/editRoom/{id}")
    public ResponseEntity<?> editRoom(@PathVariable Long id, @RequestBody RoomDto updatedRoomDto) {
        try {
            RoomDto editedRoom = roomService.editRoom(id, updatedRoomDto);
            return ResponseEntity.ok(editedRoom);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing room");
        }
    }

    @DeleteMapping("/deleteRoom/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok("Room deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting room");
        }
    }
}
