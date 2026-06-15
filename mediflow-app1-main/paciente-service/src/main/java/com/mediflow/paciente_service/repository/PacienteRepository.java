package com.mediflow.paciente_service.repository;

import com.mediflow.paciente_service.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}