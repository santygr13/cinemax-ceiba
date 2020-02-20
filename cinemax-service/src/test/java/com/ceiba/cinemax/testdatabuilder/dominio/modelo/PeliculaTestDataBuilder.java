package com.ceiba.cinemax.testdatabuilder.dominio.modelo;

import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;

public class PeliculaTestDataBuilder {


    private static final String NOMBRE="Transformers";
    private static final SalaCine SALA_CINE= new SalaCine("3",300,true);
    private static final String NUMERO_SALA_CINE="1";

    private Long idPelicula;
    private String nombre;
    private SalaCine salaCine;
    private String numeroSalaCine;

    public PeliculaTestDataBuilder() {

        this.nombre=NOMBRE;
        this.salaCine=SALA_CINE;
        this.numeroSalaCine=NUMERO_SALA_CINE;
    }



    public PeliculaTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public PeliculaTestDataBuilder conSalaCine (SalaCine salaCine){
        this.salaCine=salaCine;
        return this;
    }

    public PeliculaTestDataBuilder conNumeroSalaCine (String numeroSalaCine){
        this.numeroSalaCine=numeroSalaCine;
        return this;
    }

    public Pelicula build(){
        return new Pelicula(this.nombre,this.salaCine,this.numeroSalaCine);
    }

}
