package com.ceiba.cinemax.testdatabuilder.infraestructura.entidad;

import com.ceiba.cinemax.dominio.modelo.Factura;

import java.time.LocalDate;

public class EntidadFacturaTestDataBuilder {

    private static final LocalDate FECHA_RESERVA = LocalDate.now();
    private static final int VALOR_PAGAR=49000;

    private LocalDate fechaReserva;
    private double valor;

    public EntidadFacturaTestDataBuilder(){
        this.fechaReserva=FECHA_RESERVA;
        this.valor=VALOR_PAGAR;
    }

    public EntidadFacturaTestDataBuilder conFechaReserva(LocalDate fechaReserva){
        this.fechaReserva=fechaReserva;
        return this;
    }

    public EntidadFacturaTestDataBuilder convalor(int valorPagar){
        this.valor=valor;
        return this;
    }

    public Factura build(){
        return new Factura(this.fechaReserva,this.valor);
    }
}
