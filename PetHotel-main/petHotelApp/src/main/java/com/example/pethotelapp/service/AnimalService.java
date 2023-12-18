package com.example.pethotelapp.service;

import com.example.pethotelapp.dto.AnimalDto;
import com.example.pethotelapp.mapper.AnimalMapper;
import com.example.pethotelapp.model.AnimalModel;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.repository.AnimalRepository;
import com.example.pethotelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private  final UserRepository userRepository;

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
}