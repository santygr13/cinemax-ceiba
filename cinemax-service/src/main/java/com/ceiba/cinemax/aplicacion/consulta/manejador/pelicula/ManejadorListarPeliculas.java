package com.ceiba.cinemax.aplicacion.consulta.manejador.pelicula;


import com.ceiba.cinemax.dominio.modelo.dto.PeliculaDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPeliculas {

     private RepositorioPelicula repositorioPelicula;

    public ManejadorListarPeliculas(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public List<PeliculaDto> ejecutar(){
        return this.repositorioPelicula.listar();
    }

}
