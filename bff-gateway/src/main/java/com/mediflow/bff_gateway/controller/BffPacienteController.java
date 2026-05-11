package com.mediflow.bff_gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff/pacientes")
public class BffPacienteController {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8081/pacientes";

    public BffPacienteController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public Object listar() {
        return restTemplate.getForObject(URL, Object.class);
    }

    @PostMapping
    public Object guardar(@RequestBody Object paciente) {
        return restTemplate.postForObject(URL, paciente, Object.class);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Object paciente) {
        restTemplate.put(URL + "/" + id, paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        restTemplate.delete(URL + "/" + id);
    }
}
