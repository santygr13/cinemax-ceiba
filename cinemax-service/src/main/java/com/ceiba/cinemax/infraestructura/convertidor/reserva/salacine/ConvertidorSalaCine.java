package com.ceiba.cinemax.infraestructura.convertidor.reserva.salacine;


import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.infraestructura.entidad.SalaCineEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorSalaCine {

    private ModelMapper modelMapper = new ModelMapper();

    public SalaCineEntidad convertirSalaCineDominioAEntidad(SalaCine salaCine){
        return modelMapper.map(salaCine, SalaCineEntidad.class);
    }
    public SalaCine convertirSalaCineEntidadADominio(SalaCineEntidad salaCineEntidad){
        return modelMapper.map(salaCineEntidad, SalaCine.class);
    }


}
