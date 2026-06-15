package com.mediflow.paciente_service.controller;

import com.mediflow.paciente_service.model.Paciente;
import com.mediflow.paciente_service.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listarPacientes();
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente) {
        return service.guardarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Long id,
                               @RequestBody Paciente paciente) {
        return service.actualizarPaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminarPaciente(id);
        return "Paciente eliminado";
    }
}
