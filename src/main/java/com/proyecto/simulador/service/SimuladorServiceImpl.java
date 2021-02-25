package com.proyecto.simulador.service;

import com.proyecto.simulador.entity.Cliente;
import com.proyecto.simulador.entity.Respuesta;
import com.proyecto.simulador.entity.Simulador;
import com.proyecto.simulador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class SimuladorServiceImpl implements SimuladorService {

    @Autowired
    ClienteRepository clienteRepository;
    Respuesta respuesta;

    public Respuesta ejecutarSimulacion(Simulador simulador){
        respuesta = new Respuesta();

        Cliente clienteConsulta = clienteRepository.findByDniAndTarjeta(simulador.getDni(),simulador.getTarjeta());

        if (clienteConsulta == null) {
            respuesta.setEstado("Cliente con DNI "+simulador.getDni()+ " y tarjeta "+simulador.getTarjeta()+" no existe");
            return respuesta;
        }

        calcularSimulación(simulador);

        return respuesta;
    }

    public void calcularSimulación(Simulador simulador){

        Double Cuota,TEM,TED,FVP=0.00;
        Double TEA = Double.parseDouble(simulador.getTea().replace("%",""));
        Integer diasTranscurridos;
        LocalDate fechaPago;
        LocalDate fechaCompra = simulador.getFechaCompra();

        DecimalFormat df = new DecimalFormat("#.0000");
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Obtener fecha de pago
        fechaPago = fechaCompra.plusMonths(1);
        fechaPago = fechaPago.minusDays(fechaPago.getDayOfMonth());
        fechaPago = fechaPago.plusDays(Integer.parseInt(simulador.getDiaPago()));

        //Obtener Días transcurridos desde la fecha de compra
        diasTranscurridos = fechaPago.getDayOfYear() - fechaCompra.getDayOfYear();

        //Obtener Tasa de interes Efectiva Mensual
        TEM = Math.pow((1.00+TEA/100.00),(1/12.00))-1.00;
        TEM = Math.round(TEM * 10000.0) / 10000.0;

        //Obtener Tasa de interés Efectiva Diaria
        TED = Math.pow((1.00 + TEM),(1.00/30.00))-1.00;
        TED = Math.round(TED * 10000.0) / 10000.0;


        //Obtener Factor Valor Presente
        for(int i = 1; i <= simulador.getCuota();i++){
            FVP = FVP + Math.pow(1.00/(1.00+TED),diasTranscurridos);
            FVP = Math.round(FVP * 10000.0) / 10000.0;
            diasTranscurridos = diasTranscurridos + 30;
        }

        Cuota = simulador.getMonto()/FVP;

        respuesta.setCuota(df.format(Cuota).toString());
        respuesta.setMoneda(simulador.getMoneda());
        respuesta.setPrimeraCuota(fechaPago);
        respuesta.setEstado("exitoso");
    }
}
