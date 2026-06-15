package com.mediflow.cita_service.service;

import com.mediflow.cita_service.model.Cita;
import com.mediflow.cita_service.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public List<Cita> obtenerTodas() {
        return repository.findAll();
    }

    public Cita guardar(Cita cita) {
        return repository.save(cita);
    }

    public Cita actualizar(Long id, Cita cita) {

        Cita existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setPacienteId(cita.getPacienteId());
            existente.setMedicoId(cita.getMedicoId());
            existente.setFecha(cita.getFecha());
            existente.setHora(cita.getHora());

            return repository.save(existente);
        }

        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}