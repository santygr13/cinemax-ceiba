package com.ceiba.cinemax.testdatabuilder.infraestructura.entidad;
import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;

public class EntidadSalaCineTestDataBuilder {


    private static final String NUMERO_SALA_CINE="1";
    private static final int CAPACIDAD_SILLAS=300;
    private static final boolean ESTADO_SALA_CINE= true;




    private String numeroSalaCine;
    private int capacidadSillas;
    private boolean estadoSalaCine;

    public EntidadSalaCineTestDataBuilder() {

        this.numeroSalaCine=NUMERO_SALA_CINE;
        this.capacidadSillas=CAPACIDAD_SILLAS;
        this.estadoSalaCine=ESTADO_SALA_CINE;
    }


    public EntidadSalaCineTestDataBuilder conNumeroSalaCine(String numeroSala){
        this.numeroSalaCine=numeroSala;
        return  this;
    }

    public EntidadSalaCineTestDataBuilder conCapacidadSillas(int capacidad){
        this.capacidadSillas=capacidad;
        return  this;
    }

    public EntidadSalaCineTestDataBuilder conEstadoSalaCine(boolean estado){
        this.estadoSalaCine=estado;
        return  this;
    }

    public SalaCineEntidad build(){
        return new SalaCineEntidad(this.numeroSalaCine,this.capacidadSillas,this.estadoSalaCine);

    }
}
