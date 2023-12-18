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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/addRoom")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
        try {
            RoomDto addRoom = roomService.addRoom(roomDto);
            return ResponseEntity.ok(addRoom);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/rooms")
    public List<RoomModel> getRoomList(RoomModel room){
        List<RoomModel> roomList = roomService.getRoomList();
        return roomList;
    }


    @PostMapping("/editRoom/{id}")
    public String postEditRoom(@ModelAttribute RoomModel editRoom, RedirectAttributes redirectAttributes) {
        roomService.saveEditRoom(editRoom);
        redirectAttributes.addFlashAttribute("message", "Edycja zakończona pomyślnie");
        return "redirect:/adminpanel/allRooms";
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
