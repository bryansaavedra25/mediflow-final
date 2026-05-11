package com.mediflow.paciente_service.repository;

import com.mediflow.paciente_service.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepository {

    private List<Paciente> lista = new ArrayList<>();

    public PacienteRepository() {
        lista.add(new Paciente(1L, "Bryan", "11.111.111-1"));
        lista.add(new Paciente(2L, "Carlos", "22.222.222-2"));
    }

    public List<Paciente> obtenerPacientes() {
        return lista;
    }

    public Paciente guardar(Paciente paciente) {
        lista.add(paciente);
        return paciente;
    }

    public Paciente actualizar(Long id, Paciente pacienteActualizado) {
        for (Paciente paciente : lista) {
            if (paciente.getId().equals(id)) {
                paciente.setNombre(pacienteActualizado.getNombre());
                paciente.setRut(pacienteActualizado.getRut());
                return paciente;
            }
        }
        return null;
    }

    public void eliminar(Long id) {
        lista.removeIf(paciente -> paciente.getId().equals(id));
    }
}
