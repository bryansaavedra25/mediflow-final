package com.mediflow.medico_service.controller;

import com.mediflow.medico_service.model.Medico;
import com.mediflow.medico_service.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medico> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public String guardar(@RequestBody Medico medico) {
        service.guardar(medico);
        return "Médico guardado";
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id, @RequestBody Medico medico) {
        service.actualizar(id, medico);
        return "Médico actualizado";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Médico eliminado";
    }
}