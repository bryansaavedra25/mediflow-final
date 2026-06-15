package com.mediflow.cita_service.controller;

import com.mediflow.cita_service.model.Cita;
import com.mediflow.cita_service.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
        System.out.println("=== CONTROLADOR CITA CARGADO ===");
    }

    @GetMapping
    public List<Cita> listar() {
        return service.obtenerTodas();
    }

    @PostMapping
    public String guardar(@RequestBody Cita cita) {
        service.guardar(cita);
        return "Cita guardada";
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id, @RequestBody Cita cita) {
        service.actualizar(id, cita);
        return "Cita actualizada";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return null;
    }
}
