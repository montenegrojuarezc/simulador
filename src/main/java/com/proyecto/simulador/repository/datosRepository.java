package com.proyecto.simulador.repository;

import com.proyecto.simulador.entity.datos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface datosRepository extends JpaRepository<datos, Integer> {

}
