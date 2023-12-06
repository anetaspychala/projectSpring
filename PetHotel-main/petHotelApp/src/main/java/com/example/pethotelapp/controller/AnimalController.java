package com.example.pethotelapp.controller;

import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.model.AnimalModel;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AnimalController {
    private final AnimalService animalService;

    @PostMapping("/addAnimal")
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody AnimalDto animalDto) {
        try {
            AnimalDto addAnimal = animalService.addAnimal(animalDto);
            return ResponseEntity.ok(addAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping("/animals")
    public List<AnimalModel> getAnimalList(AnimalModel animals){
        List<AnimalModel> animalList = animalService.getAnimalList();
        return animalList;
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        try {
            animalService.deleteAnimal(id);
            return ResponseEntity.ok("Animal deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting animal");
        }
    }

    @GetMapping("/searchAnimal")
    public String getAnimalByName(@RequestParam String name, AnimalModel animals) {
        List<AnimalModel> foundAnimals = animalService.getAnimalsByName(name);

      //  animals.addAttribute("foundAnimals", foundAnimals);
        return "animalSearchResults";
    }

}
