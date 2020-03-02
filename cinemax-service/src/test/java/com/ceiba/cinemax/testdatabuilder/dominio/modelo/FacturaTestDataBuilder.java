package com.ceiba.cinemax.testdatabuilder.dominio.modelo;

import com.ceiba.cinemax.dominio.modelo.Factura;

import java.time.LocalDate;

public class FacturaTestDataBuilder {

    private static final LocalDate FECHA_RESERVA = LocalDate.of(2020,03,27);
    private static final int VALOR_PAGAR=49000;

    private LocalDate fechaReserva;
    private double valor;

    public FacturaTestDataBuilder(){
        this.fechaReserva=FECHA_RESERVA;
        this.valor=VALOR_PAGAR;
    }

    public FacturaTestDataBuilder conFechaReserva(LocalDate fechaReserva){
        this.fechaReserva=fechaReserva;
        return this;
    }

    public FacturaTestDataBuilder convalor(int valorPagar){
        this.valor=valor;
        return this;
    }


    public Factura build(){
        return new Factura(this.fechaReserva,this.valor);
    }
























}
