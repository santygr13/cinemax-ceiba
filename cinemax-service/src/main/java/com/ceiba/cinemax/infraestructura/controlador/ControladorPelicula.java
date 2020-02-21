package com.ceiba.cinemax.infraestructura.controlador;

import com.ceiba.cinemax.aplicacion.comando.ComandoPelicula;

import com.ceiba.cinemax.aplicacion.comando.manejador.pelicula.ManejadorCrearPelicula;
import com.ceiba.cinemax.aplicacion.consulta.manejador.pelicula.ManejadorListarPeliculas;
import com.ceiba.cinemax.dominio.modelo.dto.PeliculaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/pelicula")
public class ControladorPelicula {

    private final ManejadorCrearPelicula manejadorCrearPelicula;
    private final ManejadorListarPeliculas manejadorListarPeliculas;


    public ControladorPelicula(ManejadorCrearPelicula  manejadorCrearPelicula, ManejadorListarPeliculas manejadorListarPeliculas) {
        this.manejadorCrearPelicula=manejadorCrearPelicula;
        this.manejadorListarPeliculas=manejadorListarPeliculas;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarPelicula(@RequestBody ComandoPelicula comandoPelicula){
        manejadorCrearPelicula.ejecutar(comandoPelicula);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PeliculaDto> listarPelicula(){
        return this.manejadorListarPeliculas.ejecutar();
    }
}
