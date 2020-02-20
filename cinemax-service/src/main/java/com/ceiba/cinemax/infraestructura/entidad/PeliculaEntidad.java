package com.ceiba.cinemax.infraestructura.entidad;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pelicula")
public class PeliculaEntidad {



    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name= "numero_sala_cines")
    private String numeroSalaCine;

    @JoinColumn(name = "numero_sala_cine")
    @ManyToOne
    private SalaCineEntidad salaCineEntidad;

    public PeliculaEntidad( String nombre, SalaCineEntidad salaCineEntidad,String numeroSalaCine) {

        this.nombre = nombre;
        this.salaCineEntidad = salaCineEntidad;
        this.numeroSalaCine= numeroSalaCine;
    }
    public PeliculaEntidad()
    {

    }

}
