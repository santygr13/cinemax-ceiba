package com.ceiba.cinemax.infraestructura.adaptador.repositorio;

import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.modelo.dto.SalaCineDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.infraestructura.convertidor.reserva.ConvertidorListaSalaCine;
import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioSalaCineJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioSalaCinePostgreSql  implements RepositorioSalaCine {


    private ModelMapper modelMapper= new ModelMapper();
    RepositorioSalaCineJpa repositorioSalaCineJpa;
    ConvertidorListaSalaCine convertidorListaSalaCine= new ConvertidorListaSalaCine();
    public RepositorioSalaCinePostgreSql(RepositorioSalaCineJpa repositorioSalaCineJpa) {
        this.repositorioSalaCineJpa = repositorioSalaCineJpa;
    }

    @Override
    public SalaCine filtroCapacidadPorNombrePelicula(String nombrePelicula) {
        SalaCineEntidad salaCineEntidad=repositorioSalaCineJpa.capacidad(nombrePelicula);
        return modelMapper.map(salaCineEntidad,SalaCine.class);

    }

    @Override
    public boolean existe(SalaCine salaCine) {
        String numeroSalaCine = salaCine.getNumeroSalaCine();
        return(repositorioSalaCineJpa.filtroPorNumeroSalaCine(numeroSalaCine))!=null;
    }

   @Override
    public boolean noExiste(String numeroSala) {
        return(repositorioSalaCineJpa.filtroPorNumeroSalaCine(numeroSala))==null ;
    }

    @Override
    public SalaCine filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(String numeroSalacinePelicula){

        SalaCineEntidad salaCineEntidad = repositorioSalaCineJpa.filtrarSalaCinePorNumeroSalaCinePeliculaEnPelicula(numeroSalacinePelicula);
        return modelMapper.map(salaCineEntidad,SalaCine.class);

    }

    @Override
    public List<SalaCineDto> listar() {
        List<SalaCineEntidad> listSalaCineEntidad = repositorioSalaCineJpa.filtrarSalaCinePorEstadoSalaCineDisponible();
        List<SalaCineDto> listSalaCine=new ArrayList<>();
        return convertidorListaSalaCine.convertirListSalaCineEntidadAListSalaCine(listSalaCineEntidad,listSalaCine);
    }

    @Override
    public void guardar(SalaCine salaCine) {
       SalaCineEntidad salaCineEntidad=modelMapper.map(salaCine,SalaCineEntidad.class);
        repositorioSalaCineJpa.save(salaCineEntidad);
    }

    @Override
    public void guardarEstado(SalaCine salaCine) {
        SalaCineEntidad salaCineEntidad=modelMapper.map(salaCine,SalaCineEntidad.class);
        repositorioSalaCineJpa.save(salaCineEntidad);
    }


}
