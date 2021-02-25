package com.proyecto.simulador.entity;

import java.time.LocalDate;

public class Respuesta {
    private String cuota;
    private String moneda;
    private LocalDate primeraCuota;
    private String estado;

    public Respuesta() {
    }

    public Respuesta(String cuota, String moneda, LocalDate primeraCuota, String estado) {
        this.cuota = cuota;
        this.moneda = moneda;
        this.primeraCuota = primeraCuota;
        this.estado = estado;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDate getPrimeraCuota() {
        return primeraCuota;
    }

    public void setPrimeraCuota(LocalDate primeraCuota) {
        this.primeraCuota = primeraCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
