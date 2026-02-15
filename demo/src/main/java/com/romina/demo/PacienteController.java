package com.romina.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Paciente> obtenerPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPaciente(@PathVariable Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {

        Paciente paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente != null) {
            paciente.setActivo(false);
            pacienteRepository.save(paciente);
        }
    }
    }