package com.mediflow.medico_service.repository;

import com.mediflow.medico_service.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}