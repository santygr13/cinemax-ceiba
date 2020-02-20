package com.ceiba.cinemax.infraestructura.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "SalaCine")
public class SalaCineEntidad {




    @Id
    @Column(name = "numeroSalaCine")
    private String numeroSalaCine;

    @Column(name = "capacidad")
    private int capacidadSillas;

    @Column(name="estadoSalaCine")
    private boolean estadoSalaCine;

    public SalaCineEntidad( String numeroSalaCine, int capacidadSillas, boolean estadoSalaCine) {

        this.numeroSalaCine = numeroSalaCine;
        this.capacidadSillas = capacidadSillas;
        this.estadoSalaCine = estadoSalaCine;
    }
    public SalaCineEntidad(){}
}
