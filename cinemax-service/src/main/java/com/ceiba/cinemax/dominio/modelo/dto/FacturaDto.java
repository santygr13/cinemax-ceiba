package com.ceiba.cinemax.dominio.modelo.dto;



import java.time.LocalDate;

public class FacturaDto {


    private Long idFactura;
    private LocalDate fechaReserva;
    private double valor;


    public FacturaDto(){}
    public FacturaDto( LocalDate fechaReserva, double valor) {
        this.fechaReserva = fechaReserva;
        this.valor = valor;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
