package com.ceiba.cinemax.aplicacion.comando;

import com.ceiba.cinemax.dominio.modelo.SalaCine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPelicula {



    private String nombre;
    private SalaCine salaCine;
    private String numeroSalaCine;


}