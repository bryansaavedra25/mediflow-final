package com.mediflow.medico_service;

import com.mediflow.medico_service.model.Medico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MedicoServiceTest {

    @Test
    void guardarMedico() {

        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Juan Perez");
        medico.setEspecialidad("Cardiologia");

        assertNotNull(medico);
    }
}