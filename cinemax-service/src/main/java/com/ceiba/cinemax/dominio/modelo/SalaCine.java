package com.ceiba.cinemax.dominio.modelo;

import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;

public class SalaCine {

     private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";
     private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA="La cantidad de puestos debe ser mayor a 0";



     private String numeroSalaCine;
     private int capacidadSillas;
     private boolean estadoSalaCine;



     public SalaCine( String numeroSalaCine,int capacidadSillas,boolean estadoSalaCine) {

          ValidadorArgumento.validarCampoObligatorio(numeroSalaCine,ESTE_CAMPO_ES_OBLIGATORIO);
          ValidadorArgumento.validarCampoObligatorio(capacidadSillas,ESTE_CAMPO_ES_OBLIGATORIO);
          ValidadorArgumento.validarCampoObligatorio(estadoSalaCine,ESTE_CAMPO_ES_OBLIGATORIO);
          ValidadorArgumento.validadorArgumentoCantidadPositiva(capacidadSillas,LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);
          ValidadorArgumento.validarCampoVacio(numeroSalaCine,ESTE_CAMPO_ES_OBLIGATORIO);

          this.numeroSalaCine = numeroSalaCine;
          this.capacidadSillas= capacidadSillas;
          this.estadoSalaCine=estadoSalaCine;
     }

     public SalaCine(){}


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

     public boolean isEstadoSalaCine() {
          return estadoSalaCine;
     }

     public void setEstadoSalaCine(boolean estadoSalaCine) {
          this.estadoSalaCine = estadoSalaCine;
     }
}
