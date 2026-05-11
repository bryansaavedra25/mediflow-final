package com.mediflow.bff_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MedicoController {

    @GetMapping("/bff/medicos")
    public String obtenerMedicos() {

        RestTemplate restTemplate = new RestTemplate();

        String respuesta = restTemplate.getForObject(
                "http://localhost:8082/medicos",
                String.class
        );

        return respuesta;
    }
}