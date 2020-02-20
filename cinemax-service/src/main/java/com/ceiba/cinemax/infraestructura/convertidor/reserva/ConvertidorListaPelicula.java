package com.ceiba.cinemax.infraestructura.convertidor.reserva;

import com.ceiba.cinemax.dominio.modelo.dto.PeliculaDto;
import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertidorListaPelicula {

    private ModelMapper modelMapper = new ModelMapper();

    public List<PeliculaDto> convertirListPeliculaEntidadAListPelicula(List<PeliculaEntidad> listPeliculaEntidad, List<PeliculaDto> listPelicula){
        for (PeliculaEntidad peliculaEntidad: listPeliculaEntidad){
            PeliculaDto pelicula=modelMapper.map(peliculaEntidad, PeliculaDto.class);
            listPelicula.add(pelicula);
        }
        return listPelicula;
    }

}
