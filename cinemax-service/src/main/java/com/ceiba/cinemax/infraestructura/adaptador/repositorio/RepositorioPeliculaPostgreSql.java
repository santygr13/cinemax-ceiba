package com.ceiba.cinemax.infraestructura.adaptador.repositorio;


import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.dto.PeliculaDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.infraestructura.convertidor.reserva.ConvertidorListaPelicula;
import com.ceiba.cinemax.infraestructura.convertidor.reserva.salacine.ConvertidorSalaCine;
import com.ceiba.cinemax.infraestructura.entidad.PeliculaEntidad;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioPeliculaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPeliculaPostgreSql implements RepositorioPelicula {

    private RepositorioPeliculaJpa repositorioPeliculaJpa;
    private ModelMapper modelMapper= new ModelMapper();
    ConvertidorListaPelicula convertidorListaPelicula= new ConvertidorListaPelicula();
    public RepositorioPeliculaPostgreSql(RepositorioPeliculaJpa repositorioPeliculaJpa) {
        this.repositorioPeliculaJpa = repositorioPeliculaJpa;
    }


    @Override
    public boolean existe(Pelicula pelicula) {
        String nombre = pelicula.getNombre();
        return (repositorioPeliculaJpa.filtroPorNombrePelicula(nombre)) !=null;
    }

    @Override
    public boolean noExiste(String nombre) {

        return (repositorioPeliculaJpa.filtroPorNombrePelicula(nombre)) ==null;
    }


    @Override
    public void guardar(Pelicula pelicula) {
        ConvertidorSalaCine convertidorSalaCine=new ConvertidorSalaCine();
        PeliculaEntidad peliculaEntidad= modelMapper.map(pelicula,PeliculaEntidad.class);
        peliculaEntidad.setSalaCineEntidad(convertidorSalaCine.convertirSalaCineDominioAEntidad(pelicula.getSalaCine()));
        repositorioPeliculaJpa.save(peliculaEntidad);
    }



    public List<PeliculaDto> listar() {
        List<PeliculaEntidad> listPeliculaEntidad = repositorioPeliculaJpa.findAll();
        List<PeliculaDto> listReserva=new ArrayList<>();
        return convertidorListaPelicula.convertirListPeliculaEntidadAListPelicula(listPeliculaEntidad,listReserva);
    }


}
