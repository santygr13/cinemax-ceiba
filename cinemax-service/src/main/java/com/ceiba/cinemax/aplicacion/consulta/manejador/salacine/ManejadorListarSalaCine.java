package com.ceiba.cinemax.aplicacion.consulta.manejador.salacine;


import com.ceiba.cinemax.dominio.modelo.dto.SalaCineDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSalaCine {

    private RepositorioSalaCine repositorioSalaCine;

    public ManejadorListarSalaCine(RepositorioSalaCine repositorioSalaCine) {
        this.repositorioSalaCine = repositorioSalaCine;
    }

    public List<SalaCineDto> ejecutar(){
        return this.repositorioSalaCine.listar();
    }

}

