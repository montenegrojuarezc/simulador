package com.proyecto.simulador.service;

import com.proyecto.simulador.entity.datos;
import com.proyecto.simulador.repository.datosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class datosServiceImpl implements datosService{

    @Autowired
    datosRepository datos;

    public List<datos> getListarDatos(){
        List<datos> listaDatos = datos.findAll();
        return listaDatos;
    }
}
