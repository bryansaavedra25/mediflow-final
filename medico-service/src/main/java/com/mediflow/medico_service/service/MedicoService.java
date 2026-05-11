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
        return repository.obtenerTodos();
    }

    public void guardar(Medico medico) {
        repository.guardar(medico);
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    public void actualizar(Long id, Medico medico) {
        repository.actualizar(id, medico);
    }
}