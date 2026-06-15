package com.mediflow.cita_service;

import com.mediflow.cita_service.model.Cita;
import com.mediflow.cita_service.repository.CitaRepository;
import com.mediflow.cita_service.service.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaServiceTest {

    private CitaRepository repository;
    private CitaService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CitaRepository.class);
        service = new CitaService(repository);
    }

    @Test
    void debeListarCitas() {

        List<Cita> citas = Arrays.asList(
                new Cita(1L, 1L, 1L, "2026-06-15", "10:00"),
                new Cita(2L, 2L, 2L, "2026-06-16", "11:00")
        );

        when(repository.findAll()).thenReturn(citas);

        List<Cita> resultado = service.obtenerTodas();

        assertEquals(2, resultado.size());

        verify(repository).findAll();
    }

    @Test
    void debeGuardarCita() {

        Cita cita = new Cita(
                1L,
                1L,
                1L,
                "2026-06-15",
                "10:00"
        );

        when(repository.save(cita)).thenReturn(cita);

        Cita resultado = service.guardar(cita);

        assertNotNull(resultado);
        assertEquals("10:00", resultado.getHora());

        verify(repository).save(cita);
    }

    @Test
    void debeActualizarCitaExistente() {

        Long id = 1L;

        Cita existente = new Cita(
                id,
                1L,
                1L,
                "2026-06-15",
                "10:00"
        );

        Cita actualizada = new Cita(
                id,
                2L,
                3L,
                "2026-06-20",
                "15:00"
        );

        when(repository.findById(id))
                .thenReturn(Optional.of(existente));

        when(repository.save(any(Cita.class)))
                .thenAnswer(i -> i.getArgument(0));

        Cita resultado = service.actualizar(id, actualizada);

        assertNotNull(resultado);
        assertEquals("15:00", resultado.getHora());

        verify(repository).findById(id);
        verify(repository).save(any(Cita.class));
    }

    @Test
    void noDebeActualizarCitaInexistente() {

        Long id = 99L;

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        Cita resultado = service.actualizar(
                id,
                new Cita()
        );

        assertNull(resultado);

        verify(repository).findById(id);
        verify(repository, never()).save(any());
    }

    @Test
    void debeEliminarCita() {

        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        service.eliminar(id);

        verify(repository).deleteById(id);
    }
}