package com.ceiba.cinemax.dominio.modelo.dto;

import com.ceiba.cinemax.dominio.modelo.SalaCine;

public class SalaCineDto {


    private boolean estadoSalaCine;
    private String numeroSalaCine;
    private int capacidadSillas;



    public SalaCineDto() {
        //Permite adapatar datos a una salida especifica
    }

    public SalaCineDto(String numeroSalaCine, int capacidadSillas,boolean estadoSalaCine) {
        this.estadoSalaCine = estadoSalaCine;
        this.numeroSalaCine = numeroSalaCine;
        this.capacidadSillas = capacidadSillas;
    }


    public boolean isEstadoSalaCine() {
        return estadoSalaCine;
    }

    public void setEstadoSalaCine(boolean estadoSalaCine) {
        this.estadoSalaCine = estadoSalaCine;
    }

    public String getNumeroSalaCine() {
        return numeroSalaCine;
    }

    public void setNumeroSalaCine(String numeroSalaCine) {
        this.numeroSalaCine = numeroSalaCine;
    }

    public int getCapacidadSillas() {
        return capacidadSillas;
    }

    public void setCapacidadSillas(int capacidadSillas) {
        this.capacidadSillas = capacidadSillas;
    }

    public SalaCine build(){
        return new SalaCine(this.numeroSalaCine,this.capacidadSillas,this.estadoSalaCine);
    }

}
