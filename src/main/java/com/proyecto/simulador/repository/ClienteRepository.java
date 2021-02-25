package com.proyecto.simulador.repository;

import com.proyecto.simulador.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente where dni = :dni and tarjeta = :tarjeta", nativeQuery = true)
    Cliente findExistencia(String dni, String tarjeta);
    Cliente findByDniAndTarjeta(String dni, String tarjeta);
}
