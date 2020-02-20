package com.ceiba.cinemax.aplicacion.comando.fabrica;

import com.ceiba.cinemax.aplicacion.comando.ComandoPelicula;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class FabricaPelicula {

    public Pelicula crear(ComandoPelicula comandoPelicula){
        return new Pelicula(comandoPelicula.getNombre(),comandoPelicula.getSalaCine(),comandoPelicula.getNumeroSalaCine());
    }

}
