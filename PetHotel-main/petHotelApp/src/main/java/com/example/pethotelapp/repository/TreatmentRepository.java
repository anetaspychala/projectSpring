package com.example.pethotelapp.repository;

import com.example.pethotelapp.model.TreatmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentModel, Long> {
}
