package com.ceiba.cinemax.dominio.modelo.dto;
import java.time.LocalDate;

public class ReservaDto {
    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private FacturaDto facturaDto;


    public ReservaDto() {
        //Permite adapatar datos a una salida especifica
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReservaPelicula() {
        return fechaReservaPelicula;
    }

    public void setFechaReservaPelicula(LocalDate fechaReservaPelicula) {
        this.fechaReservaPelicula = fechaReservaPelicula;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public FacturaDto getFacturaDto() {
        return facturaDto;
    }

    public void setFacturaDto(FacturaDto facturaDto) {
        this.facturaDto = facturaDto;
    }


}
