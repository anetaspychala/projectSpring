package com.example.pethotelapp.repository;


import com.example.pethotelapp.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    List<AnimalModel> findByNameIgnoreCase(String name);
}
