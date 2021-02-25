package com.proyecto.simulador.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Cliente")
public class Cliente{

    @Id
    private Integer id;
    private String dni;
    private String nombres;
    private String tarjeta;

    public Cliente(Integer id, String dni, String nombres, String tarjeta) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.tarjeta = tarjeta;
    }

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
}
