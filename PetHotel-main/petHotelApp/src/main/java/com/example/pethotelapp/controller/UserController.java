package com.example.pethotelapp.controller;

import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.service.UserService;
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
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsersList(UserModel user){
        List<UserModel> userList = userService.getUsersList();
        return userList;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserDto updatedUserDto) {
        try {
            UserDto editedUser = userService.editUser(id, updatedUserDto);
            return ResponseEntity.ok(editedUser);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing user");
        }
    }
}