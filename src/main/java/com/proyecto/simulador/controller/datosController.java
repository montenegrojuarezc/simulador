package com.proyecto.simulador.controller;

import com.proyecto.simulador.entity.datos;
import com.proyecto.simulador.service.datosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class datosController {

    @Autowired
    datosService datos;

    @GetMapping("listarDatos")
    public List<datos> home(){
        return datos.getListarDatos();
    }
}
