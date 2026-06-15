package com.mediflow.medico_service;

import com.mediflow.medico_service.model.Medico;
import com.mediflow.medico_service.repository.MedicoRepository;
import com.mediflow.medico_service.service.MedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MedicoServiceTest {

    private MedicoRepository repository;
    private MedicoService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(MedicoRepository.class);
        service = new MedicoService(repository);
    }

    @Test
    void debeListarMedicos() {

        List<Medico> medicos = Arrays.asList(
                new Medico(1L, "Juan Perez", "Cardiologia"),
                new Medico(2L, "Ana Soto", "Pediatria")
        );

        when(repository.findAll()).thenReturn(medicos);

        List<Medico> resultado = service.obtenerTodos();

        assertEquals(2, resultado.size());

        verify(repository).findAll();
    }

    @Test
    void debeGuardarMedico() {

        Medico medico = new Medico(1L, "Juan Perez", "Cardiologia");

        when(repository.save(medico)).thenReturn(medico);

        Medico resultado = service.guardar(medico);

        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombre());

        verify(repository).save(medico);
    }

    @Test
    void debeActualizarMedicoExistente() {

        Long id = 1L;

        Medico existente =
                new Medico(id, "Juan Perez", "Cardiologia");

        Medico actualizado =
                new Medico(id, "Juan Actualizado", "Neurologia");

        when(repository.findById(id))
                .thenReturn(Optional.of(existente));

        when(repository.save(any(Medico.class)))
                .thenAnswer(i -> i.getArgument(0));

        Medico resultado = service.actualizar(id, actualizado);

        assertNotNull(resultado);
        assertEquals("Juan Actualizado", resultado.getNombre());
        assertEquals("Neurologia", resultado.getEspecialidad());

        verify(repository).findById(id);
        verify(repository).save(any(Medico.class));
    }

    @Test
    void noDebeActualizarMedicoInexistente() {

        Long id = 99L;

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        Medico resultado = service.actualizar(
                id,
                new Medico()
        );

        assertNull(resultado);

        verify(repository).findById(id);
        verify(repository, never()).save(any());
    }

    @Test
    void debeEliminarMedico() {

        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        service.eliminar(id);

        verify(repository).deleteById(id);
    }
}