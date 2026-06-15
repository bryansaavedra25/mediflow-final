package com.mediflow.paciente_service;

import com.mediflow.paciente_service.model.Paciente;
import com.mediflow.paciente_service.repository.PacienteRepository;
import com.mediflow.paciente_service.service.PacienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacienteServiceTest {

    private PacienteRepository repository;
    private PacienteService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(PacienteRepository.class);
        service = new PacienteService(repository);
    }

    @Test
    void debeListarPacientes() {

        List<Paciente> pacientes = Arrays.asList(
                new Paciente(1L, "Juan Perez", "11111111-1"),
                new Paciente(2L, "Maria Lopez", "22222222-2")
        );

        when(repository.findAll()).thenReturn(pacientes);

        List<Paciente> resultado = service.listarPacientes();

        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void debeGuardarPaciente() {

        Paciente paciente =
                new Paciente(1L, "Juan Perez", "11111111-1");

        when(repository.save(paciente)).thenReturn(paciente);

        Paciente resultado = service.guardarPaciente(paciente);

        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombre());

        verify(repository, times(1)).save(paciente);
    }

    @Test
    void debeActualizarPacienteExistente() {

        Long id = 1L;

        Paciente existente =
                new Paciente(id, "Juan Perez", "11111111-1");

        Paciente actualizado =
                new Paciente(id, "Juan Actualizado", "99999999-9");

        when(repository.findById(id))
                .thenReturn(Optional.of(existente));

        when(repository.save(any(Paciente.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Paciente resultado =
                service.actualizarPaciente(id, actualizado);

        assertNotNull(resultado);
        assertEquals("Juan Actualizado", resultado.getNombre());
        assertEquals("99999999-9", resultado.getRut());

        verify(repository).findById(id);
        verify(repository).save(any(Paciente.class));
    }

    @Test
    void noDebeActualizarPacienteInexistente() {

        Long id = 99L;

        Paciente paciente =
                new Paciente(id, "Juan", "11111111-1");

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        Paciente resultado =
                service.actualizarPaciente(id, paciente);

        assertNull(resultado);

        verify(repository).findById(id);
        verify(repository, never()).save(any());
    }

    @Test
    void debeEliminarPaciente() {

        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        service.eliminarPaciente(id);

        verify(repository, times(1)).deleteById(id);
    }
}