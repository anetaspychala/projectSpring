package com.example.pethotelapp.repository;

import com.example.pethotelapp.model.RoleModel;
import com.example.pethotelapp.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoomModel,Long> {
    Optional<RoleModel> findByName(String name);


}
