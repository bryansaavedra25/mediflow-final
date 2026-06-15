package com.mediflow.medico_service.repository;

import com.mediflow.medico_service.model.Medico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicoRepository {

    private List<Medico> lista = new ArrayList<>();

    public List<Medico> obtenerTodos() {
        return lista;
    }

    public void guardar(Medico medico) {
        lista.add(medico);
    }

    public void eliminar(Long id) {
        lista.removeIf(m -> m.getId().equals(id));
    }

    public void actualizar(Long id, Medico medicoActualizado) {
        for (Medico m : lista) {
            if (m.getId().equals(id)) {
                m.setNombre(medicoActualizado.getNombre());
                m.setEspecialidad(medicoActualizado.getEspecialidad());
            }
        }
    }
}