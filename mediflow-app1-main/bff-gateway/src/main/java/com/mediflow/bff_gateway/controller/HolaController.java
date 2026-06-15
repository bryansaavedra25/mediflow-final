package com.mediflow.bff_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String inicio() {
        return "Inicio MediFlow";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola MediFlow";
    }
}