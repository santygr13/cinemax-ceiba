package com.ceiba.cinemax.testdatabuilder.infraestructura.entidad;


import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;


public class EntidadPeliculaTestDataBuilder {


    private static final String NOMBRE="Transformers";
    private static final SalaCineEntidad SALA_CINE= new SalaCineEntidad("1",300,true);
    private static final String NUMERO_SALA_CINE="1";

    private String nombre;
    private SalaCineEntidad salaCine;
    private String numeroSalaCine;

    public EntidadPeliculaTestDataBuilder() {

        this.nombre=NOMBRE;
        this.salaCine=SALA_CINE;
        this.numeroSalaCine=NUMERO_SALA_CINE;
    }



    public EntidadPeliculaTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public EntidadPeliculaTestDataBuilder conSalaCine (SalaCineEntidad salaCine){
        this.salaCine=salaCine;
        return this;
    }

    public EntidadPeliculaTestDataBuilder conSalaCine (String numeroSalaCine){
        this.numeroSalaCine=numeroSalaCine;
        return this;
    }

    public PeliculaEntidad build(){
        return new PeliculaEntidad(this.nombre,this.salaCine,this.numeroSalaCine);
    }
}
