package com.ceiba.cinemax.aplicacion.comando.manejador.pelicula;

import com.ceiba.cinemax.aplicacion.comando.ComandoPelicula;
import com.ceiba.cinemax.aplicacion.comando.fabrica.FabricaPelicula;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.servicio.pelicula.ServicioCrearPelicula;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPelicula {

    private final ServicioCrearPelicula servicioCrearPelicula;
    private final FabricaPelicula fabricaPelicula;

    public ManejadorCrearPelicula(ServicioCrearPelicula servicioCrearPelicula,FabricaPelicula fabricaPelicula) {
        this.servicioCrearPelicula=servicioCrearPelicula;
        this.fabricaPelicula=fabricaPelicula;
    }

    public void ejecutar(ComandoPelicula comandoPelicula){
        Pelicula pelicula= this.fabricaPelicula.crear(comandoPelicula);
        this.servicioCrearPelicula.ejecutar(pelicula);
    }






}

