package com.ceiba.cinemax.dominio.modelo.dto;




public class PeliculaDto {

    private Long idPelicula;
    private String nombre;
    private SalaCineDto salaCine;
    private String numeroSalaCine;

    public PeliculaDto() {
        //Permite adapatar datos a una salida especifica
    }


    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SalaCineDto getSalaCine() {
        return salaCine;
    }

    public void setSalaCine(SalaCineDto salaCine) {
        this.salaCine = salaCine;
    }

    public String getNumeroSalaCine() {
        return numeroSalaCine;
    }

    public void setNumeroSalaCine(String numeroSalaCine) {
        this.numeroSalaCine = numeroSalaCine;
    }



}
