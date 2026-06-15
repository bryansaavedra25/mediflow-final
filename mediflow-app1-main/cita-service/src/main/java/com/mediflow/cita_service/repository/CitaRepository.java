package com.mediflow.cita_service.repository;

import com.mediflow.cita_service.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}