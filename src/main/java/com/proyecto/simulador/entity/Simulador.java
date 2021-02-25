package com.proyecto.simulador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;


public class Simulador {

    @NotNull(message = "Debe ingresar un número de DNI")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    private String dni;
    @NotNull(message = "Debe ingresar un nombre de Tarjeta (Clásica, Oro o Black)")
    private String tarjeta;
    @NotNull(message = "Debe ingresar el tipo de moneda (S/)")
    private String moneda;
    @NotNull(message = "Debe ingresar el monto (mínimo 1 Sol)")
    @Min(value = 1, message = "El monto mínimo es 1 Sol")
    private Double monto;
    @NotNull(message = "Debe ingresar la cuota de 1 a 36")
    @Min(value = 1, message = "La cuota mínima es 1")
    @Max(value = 36, message = "La cuota máxima es 36")
    private Integer cuota;
    @NotNull(message = "Debe ingresar la TEA")
    private String tea;
    @NotNull(message = "Debe ingresar el día de pago")
    private String diaPago;
    @NotNull(message = "Debe ingresar la fecha de compra")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCompra;

    public Simulador() {
    }

    public Simulador(String dni, String tarjeta, String moneda, Double monto, Integer cuota, String tea, String diaPago, LocalDate fechaCompra) {
        this.dni = dni;
        this.tarjeta = tarjeta;
        this.moneda = moneda;
        this.monto = monto;
        this.cuota = cuota;
        this.tea = tea;
        this.diaPago = diaPago;
        this.fechaCompra = fechaCompra;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(String diaPago) {
        this.diaPago = diaPago;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
