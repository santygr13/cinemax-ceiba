package com.ceiba.cinemax.aplicacion.comando.fabrica;


import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalaCine {

    public SalaCine crear (ComandoSalaCine comandoSalaCine){
        return new SalaCine(comandoSalaCine.getNumeroSalaCine(),
                comandoSalaCine.getCapacidadSillas(),comandoSalaCine.isEstadoSalaCine());
    }
}
