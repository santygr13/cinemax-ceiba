package com.ceiba.cinemax.infraestructura.convertidor.reserva.pelicula;

import com.ceiba.cinemax.dominio.modelo.Pelicula;

import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorPelicula {


    private ModelMapper modelMapper = new ModelMapper();

    public PeliculaEntidad convertirPeliculaDominioAEntidad(Pelicula pelicula){
        return modelMapper.map(pelicula,PeliculaEntidad.class);
    }


}
