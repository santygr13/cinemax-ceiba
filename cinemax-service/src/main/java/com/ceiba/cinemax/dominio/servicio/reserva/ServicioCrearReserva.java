package com.ceiba.cinemax.dominio.servicio.reserva;


import com.ceiba.cinemax.dominio.excepcion.ExcepcionExistenciaPelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.cinemax.dominio.servicio.salacine.ServicioCapacidadSalaCine;


public class ServicioCrearReserva {

    private static final String LA_PELICULA_NO_EXISTE="La pelicula no existe";


    private  RepositorioReserva repositorioReserva;
    private RepositorioPelicula repositorioPelicula;
    private ServicioCapacidadSalaCine servicioCapacidadSalaCine;
    private ServicioCrearFactura servicioCrearFactura;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioPelicula repositorioPelicula, ServicioCapacidadSalaCine servicioCapacidadSalaCine,ServicioCrearFactura servicioCrearFactura) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioPelicula = repositorioPelicula;
        this.servicioCapacidadSalaCine = servicioCapacidadSalaCine;
        this.servicioCrearFactura=servicioCrearFactura;
    }

    private void validarExistenciaPelicula(String nombre){
        boolean existe = this.repositorioPelicula.existe(nombre);
        if (!existe){
            throw new ExcepcionExistenciaPelicula(LA_PELICULA_NO_EXISTE);
        }
    }


    public void ejecutar(Reserva reserva){

        this.validarExistenciaPelicula(reserva.getNombrePelicula());
        servicioCapacidadSalaCine.reducirCapacidadSalaCine(reserva.getNombrePelicula(),reserva.getCantidadPuestos());
        reserva.setFactura(servicioCrearFactura.construirFactura(reserva));
        this.repositorioReserva.guardar(reserva);

    }



}
