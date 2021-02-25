package com.proyecto.simulador.service;

import com.proyecto.simulador.entity.Cliente;
import com.proyecto.simulador.entity.Respuesta;
import com.proyecto.simulador.entity.Simulador;
import org.springframework.http.ResponseEntity;

public interface SimuladorService {
    public Respuesta ejecutarSimulacion(Simulador simulador);
}
