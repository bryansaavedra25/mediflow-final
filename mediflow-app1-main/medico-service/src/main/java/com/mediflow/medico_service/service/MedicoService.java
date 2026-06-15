package com.mediflow.medico_service.service;

import com.mediflow.medico_service.model.Medico;
import com.mediflow.medico_service.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> obtenerTodos() {
        return repository.findAll();
    }

    public Medico guardar(Medico medico) {
        return repository.save(medico);
    }

    public Medico actualizar(Long id, Medico medico) {

        Medico existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNombre(medico.getNombre());
            existente.setEspecialidad(medico.getEspecialidad());

            return repository.save(existente);
        }

        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}