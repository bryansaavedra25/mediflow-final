package com.mediflow.paciente_service;

import com.mediflow.paciente_service.model.Paciente;
import com.mediflow.paciente_service.repository.PacienteRepository;
import com.mediflow.paciente_service.service.PacienteService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteServiceTest {

    @Test
    void guardarPaciente() {

        PacienteRepository repository =
                Mockito.mock(PacienteRepository.class);

        PacienteService service =
                new PacienteService(repository);

        Paciente paciente =
                new Paciente(1L,"Juan Perez","11111111-1");

        Mockito.when(repository.save(paciente))
                .thenReturn(paciente);

        Paciente resultado =
                service.guardar(paciente);

        assertEquals("Juan Perez",
                resultado.getNombre());
    }
}
