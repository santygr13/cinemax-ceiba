package com.ceiba.cinemax.testdatabuilder.dominio.modelo;

import com.ceiba.cinemax.dominio.modelo.SalaCine;

public class SalaCineTestDataBuilder {


    private static final String NUMERO_SALA_CINE="3";
    private static final int CAPACIDAD_SILLAS=300;
    private static final boolean ESTADO_SALA_CINE= true;

    private String numeroSalaCine;
    private int capacidadSillas;
    private boolean estadoSalaCine;

    public SalaCineTestDataBuilder() {

        this.numeroSalaCine=NUMERO_SALA_CINE;
        this.capacidadSillas=CAPACIDAD_SILLAS;
        this.estadoSalaCine=ESTADO_SALA_CINE;

    }

    public SalaCineTestDataBuilder conNumeroSalaCine(String numeroSala){
        this.numeroSalaCine=numeroSala;
        return  this;
    }

    public SalaCineTestDataBuilder conCapacidadSillas(int capacidad){
        this.capacidadSillas=capacidad;
        return  this;
    }

    public SalaCineTestDataBuilder conEstadoSalaCine(boolean estado){
        this.estadoSalaCine=estado;
        return  this;
    }

    public SalaCine build(){
        return  new SalaCine(this.numeroSalaCine,this.capacidadSillas,this.estadoSalaCine);

    }
}
