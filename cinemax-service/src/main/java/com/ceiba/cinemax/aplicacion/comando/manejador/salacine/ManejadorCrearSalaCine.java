package com.ceiba.cinemax.aplicacion.comando.manejador.salacine;

import com.ceiba.cinemax.aplicacion.comando.ComandoSalaCine;
import com.ceiba.cinemax.aplicacion.comando.fabrica.FabricaSalaCine;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCrearSalaCine;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSalaCine {

    private final ServicioCrearSalaCine servicioCrearSalaCine;
    private final FabricaSalaCine fabricaSalaCine;

    public ManejadorCrearSalaCine(ServicioCrearSalaCine servicioCrearSalaCine, FabricaSalaCine fabricaSalaCine) {
        this.servicioCrearSalaCine = servicioCrearSalaCine;
        this.fabricaSalaCine = fabricaSalaCine;
    }

    public void ejecutar(ComandoSalaCine comandoSalaCine){
        SalaCine salaCine= this.fabricaSalaCine.crear(comandoSalaCine);
        this.servicioCrearSalaCine.ejecutar(salaCine);
    }
}
