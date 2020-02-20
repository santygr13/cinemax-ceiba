package com.ceiba.cinemax.testdatabuilder.aplicacion;

import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;

public class ComandoSalaCineTestDataBuilder {


    private static final String NUMERO_SALA_CINE="4";
    private static final int CAPACIDAD_SILLAS=300;
    private static final boolean ESTADO_SALA_CINE= true;



    private String numeroSalaCine;
    private int capacidadSillas;
    private boolean estadoSalaCine;

    public ComandoSalaCineTestDataBuilder() {

        this.numeroSalaCine=NUMERO_SALA_CINE;
        this.capacidadSillas=CAPACIDAD_SILLAS;
        this.estadoSalaCine=ESTADO_SALA_CINE;
    }



    public ComandoSalaCineTestDataBuilder conNumeroSalaCine(String numeroSalaCine){
        this.numeroSalaCine=numeroSalaCine;
        return this;
    }

    public ComandoSalaCineTestDataBuilder conCapacidadSillas(int capacidadSillas){
        this.capacidadSillas=capacidadSillas;
        return this;
    }

    public ComandoSalaCineTestDataBuilder conEstadoSalaCine(boolean estadoSalaCine){
        this.estadoSalaCine=estadoSalaCine;
        return this;
    }

    public ComandoSalaCine build(){
        return new ComandoSalaCine(this.numeroSalaCine,this.capacidadSillas,this.estadoSalaCine);
    }
}
