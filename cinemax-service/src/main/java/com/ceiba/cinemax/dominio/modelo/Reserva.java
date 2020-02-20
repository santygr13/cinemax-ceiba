package com.ceiba.cinemax.dominio.modelo;

import com.ceiba.cinemax.dominio.validador.ValidadorArgumento;

import java.time.LocalDate;

public class Reserva {


    private static final String ESTE_CAMPO_ES_OBLIGATORIO="El campo es obligatorio";
    private static final String ERROR_FECHA_RESERVA="La fecha de reserva no es valida";
    private static final String LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA="La cantidad de puestos debe de ser mayor a 0";

    private Long idReserva;
    private LocalDate fechaReservaPelicula;
    private int cantidadPuestos;
    private int documentoCliente;
    private String nombreCliente;
    private String nombrePelicula;
    private Factura factura;

    public Reserva(Long idReserva, LocalDate fechaReservaPelicula,
                    int documentoCliente,String nombreCliente, int cantidadPuestos, String nombrePelicula,Factura factura) {


        ValidadorArgumento.validarCampoObligatorio(cantidadPuestos,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(documentoCliente,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoVacio(nombrePelicula,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validadorFechaValida(fechaReservaPelicula,ERROR_FECHA_RESERVA);
        ValidadorArgumento.validadorArgumentoCantidadPositiva(cantidadPuestos,LA_CANTIDAD_NO_PUEDE_SER_NEGATIVA);
        ValidadorArgumento.validarCampoVacio(fechaReservaPelicula,ESTE_CAMPO_ES_OBLIGATORIO);
        ValidadorArgumento.validarCampoVacio(nombreCliente,ESTE_CAMPO_ES_OBLIGATORIO);

        this.idReserva = idReserva;
        this.fechaReservaPelicula = fechaReservaPelicula;
        this.cantidadPuestos = cantidadPuestos;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.factura=factura;
        this.nombrePelicula=nombrePelicula;

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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
