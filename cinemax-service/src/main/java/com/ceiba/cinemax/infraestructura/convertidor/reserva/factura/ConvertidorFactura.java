package com.ceiba.cinemax.infraestructura.convertidor.reserva.factura;

import com.ceiba.cinemax.dominio.modelo.Factura;
import com.ceiba.cinemax.infraestructura.entidad.FacturaEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorFactura {


    private ModelMapper modelMapper = new ModelMapper();

    public FacturaEntidad convertirFacturaDominioAEntidad(Factura factura){
        return modelMapper.map(factura,FacturaEntidad.class);
    }


}
