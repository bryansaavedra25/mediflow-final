package com.mediflow.bff_gateway.service;

import com.mediflow.bff_gateway.model.Paciente;
import com.mediflow.bff_gateway.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarPacientes() {

        return repository.obtenerPacientes();
    }

    public Paciente guardarPaciente(Paciente paciente) {

        return repository.guardar(paciente);
    }

    public Paciente actualizarPaciente(Long id, Paciente paciente) {

        return repository.actualizar(id, paciente);
    }

    public void eliminarPaciente(Long id) {

        repository.eliminar(id);
    }
}