package com.ceiba.cinemax.infraestructura.configuracion;

import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.cinemax.dominio.servicio.reserva.ServicioCrearReserva;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCapacidadSalaCine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioReserva {

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva , RepositorioPelicula repositorioPelicula, ServicioCapacidadSalaCine servicioCapacidadSalaCine,ServicioCrearFactura servicioCrearFactura){
        return new ServicioCrearReserva(repositorioReserva,repositorioPelicula, servicioCapacidadSalaCine,servicioCrearFactura);
    }


}
