package com.example.pethotelapp.service;

import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.dto.RoomDto;
import com.example.pethotelapp.mapper.AnimalMapper;
import com.example.pethotelapp.mapper.RoomMapper;
import com.example.pethotelapp.model.AnimalModel;
import com.example.pethotelapp.model.RoomModel;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.repository.AnimalRepository;
import com.example.pethotelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;

    public AnimalDto addAnimal(AnimalDto animalDto) {
        AnimalModel animalModel = AnimalMapper.toAnimalModel(animalDto);
        //  UserModel userModel = userRepository.findById(animalDto.getOwnerId()).orElseThrow();
        //animalModel.setUser(userModel);
        AnimalModel addAnimal = animalRepository.save(animalModel);
        return AnimalMapper.toAnimalDto(addAnimal);
    }

    public List<AnimalModel> getAnimalList() {
        return animalRepository.findAll();
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<AnimalModel> getAnimalsByName(String name) {
        return animalRepository.findByNameIgnoreCase(name);
    }

    public AnimalDto editAnimal(Long id, AnimalDto updatedAnimalDto) {
        Optional<AnimalModel> animalOptional = animalRepository.findById(id);

        if (animalOptional.isPresent()) {
            AnimalModel existingAnimal = animalOptional.get();
            existingAnimal.setName(updatedAnimalDto.getName());
            existingAnimal.setType(updatedAnimalDto.getType());
            existingAnimal.setSex(updatedAnimalDto.getSex());
            existingAnimal.setWeight(updatedAnimalDto.getWeight());
            AnimalModel updatedAnimal = animalRepository.save(existingAnimal);
            return AnimalMapper.toAnimalDto(updatedAnimal);
        } else {
            throw new NoSuchElementException("Animal with id " + id + " not found");
        }
    }
}