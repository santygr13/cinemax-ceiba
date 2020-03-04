package com.ceiba.cinemax.dominio.puerto.repositorio;


import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.dto.PeliculaDto;
import java.util.List;

public interface RepositorioPelicula {


    boolean existe(String nombre);
    void guardar(Pelicula pelicula);
    List<PeliculaDto> listar();

}
