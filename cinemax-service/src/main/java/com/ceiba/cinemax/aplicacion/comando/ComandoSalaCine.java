package com.ceiba.cinemax.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSalaCine {


    private String numeroSalaCine;
    private int capacidadSillas;
    private boolean estadoSalaCine;

}
