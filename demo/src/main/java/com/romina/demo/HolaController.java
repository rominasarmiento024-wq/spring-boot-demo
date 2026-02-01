package com.romina.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String hola() {
        return "Hola Romina, Spring Boot está funcionando 🚀";
    }
}
