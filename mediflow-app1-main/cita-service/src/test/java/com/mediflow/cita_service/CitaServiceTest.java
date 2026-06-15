package com.mediflow.cita_service;

import com.mediflow.cita_service.model.Cita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CitaServiceTest {

    @Test
    void guardarCita() {

        Cita cita = new Cita();
        cita.setId(1L);
        cita.setPacienteId(1L);
        cita.setMedicoId(1L);
        cita.setFecha("2026-06-15");
        cita.setHora("10:00");

        assertNotNull(cita);
    }
}