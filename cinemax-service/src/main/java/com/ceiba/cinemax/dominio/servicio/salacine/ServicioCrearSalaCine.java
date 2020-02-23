package com.ceiba.cinemax.dominio.servicio.salacine;

import com.ceiba.cinemax.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearSalaCine {


    private static final String LA_SALA_CINE_YA_EXISTE="La sala de cine ya se encuentra registrada";

    RepositorioSalaCine repositorioSalaCine;

    public ServicioCrearSalaCine(RepositorioSalaCine repositorioSalaCine) {
        this.repositorioSalaCine = repositorioSalaCine;
    }

    public void validarExistencia(SalaCine salaCine){
        boolean existe = this.repositorioSalaCine.existe(salaCine);
        if (existe){
            throw new ExcepcionDuplicidad(LA_SALA_CINE_YA_EXISTE);
        }
    }


    public void ejecutar(SalaCine salaCine){
        this.validarExistencia(salaCine);
        this.repositorioSalaCine.guardar(salaCine);


    }


}
