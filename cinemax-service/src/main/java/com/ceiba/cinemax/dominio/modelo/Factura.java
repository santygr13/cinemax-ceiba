package com.ceiba.cinemax.dominio.modelo;

import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;
import java.time.LocalDate;

public class Factura {

    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";

    private LocalDate fechaReserva;
    private double valor;


    public Factura(LocalDate fechaReserva, double valor) {

        ValidadorArgumento.validarCampoObligatorio(valor,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(fechaReserva,ESTE_CAMPO_ES_OBLIGATORIO);
        this.fechaReserva = fechaReserva;
        this.valor = valor;
    }




    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
