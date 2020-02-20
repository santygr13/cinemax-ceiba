package com.ceiba.cinemax.dominio.modelo;

import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;

public class Pelicula {

    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";


    private String nombre;
    private SalaCine salaCine;
    private String numeroSalaCine;



    public Pelicula(String nombre, SalaCine salaCine,String numeroSalaCine){

        ValidadorArgumento.validarCampoObligatorio(nombre,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoVacio(numeroSalaCine,ESTE_CAMPO_ES_OBLIGATORIO);
        this.nombre = nombre;
        this.salaCine=salaCine;
        this.numeroSalaCine=numeroSalaCine;
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SalaCine getSalaCine() {
        return salaCine;
    }

    public void setSalaCine(SalaCine salaCine) {
        this.salaCine = salaCine;
    }

    public String getNumeroSalaCine() {
        return numeroSalaCine;
    }

    public void setNumeroSalaCine(String numeroSalaCine) {
        this.numeroSalaCine = numeroSalaCine;
    }

}
