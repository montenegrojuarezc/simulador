package com.proyecto.simulador.controller;

import com.proyecto.simulador.entity.Respuesta;
import com.proyecto.simulador.entity.Simulador;
import com.proyecto.simulador.service.SimuladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class SimuladorController {

    @Autowired
    SimuladorService simuladorService;

    @PostMapping("simulador")
    public Respuesta ejecutarSimulacion(@Valid @RequestBody Simulador simulador){

        return simuladorService.ejecutarSimulacion(simulador);
    }
}

