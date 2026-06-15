package com.mediflow.paciente_service.service;

import com.mediflow.paciente_service.model.Paciente;
import com.mediflow.paciente_service.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente actualizarPaciente(Long id, Paciente paciente) {

        Paciente existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNombre(paciente.getNombre());
            existente.setRut(paciente.getRut());

            return repository.save(existente);
        }

        return null;
    }

    public void eliminarPaciente(Long id) {
        repository.deleteById(id);
    }

    public Paciente guardar(Paciente paciente) {
    return repository.save(paciente);
    }
}