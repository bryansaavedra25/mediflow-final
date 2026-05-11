package com.mediflow.bff_gateway.controller;

import com.mediflow.bff_gateway.model.Paciente;
import com.mediflow.bff_gateway.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

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