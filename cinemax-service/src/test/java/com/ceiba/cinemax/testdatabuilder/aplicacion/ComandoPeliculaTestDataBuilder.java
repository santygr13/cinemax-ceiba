package com.ceiba.cinemax.testdatabuilder.aplicacion;

import com.ceiba.cinemax.aplicacion.comando.ComandoPelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;



public class ComandoPeliculaTestDataBuilder {


    private static final String NOMBRE_PELICULA="TRANSFORMERS";
    private static final SalaCine SALA_CINE= new SalaCine("1",200,true);
    private static final String NUMERO_SALA_CINE="1";




    private String nombre;
    private SalaCine salaCine;
    private String numeroSalaCine;


    public ComandoPeliculaTestDataBuilder() {

        this.nombre = NOMBRE_PELICULA;
        this.salaCine = SALA_CINE;
        this.numeroSalaCine = NUMERO_SALA_CINE;
    }



    public ComandoPeliculaTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ComandoPeliculaTestDataBuilder conSalaCine(SalaCine salaCine){
        this.salaCine=salaCine;
        return this;
    }

    public ComandoPeliculaTestDataBuilder conNumeroSalaCine(String numeroSalaCine){
        this.numeroSalaCine=numeroSalaCine;
        return this;
    }

    public ComandoPelicula build(){
        return new ComandoPelicula(this.nombre,this.salaCine,this.numeroSalaCine);
    }
}
