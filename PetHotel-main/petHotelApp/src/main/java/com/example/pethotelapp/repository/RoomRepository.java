package com.example.pethotelapp.repository;

import com.example.pethotelapp.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel,Long> {
}
