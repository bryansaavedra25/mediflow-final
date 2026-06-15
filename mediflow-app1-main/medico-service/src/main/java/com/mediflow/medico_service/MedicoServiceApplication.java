package com.mediflow.medico_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mediflow.medico_service.repository")
public class MedicoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicoServiceApplication.class, args);
    }
}