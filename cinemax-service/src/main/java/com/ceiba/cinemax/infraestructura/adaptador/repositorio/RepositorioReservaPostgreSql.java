package com.ceiba.cinemax.infraestructura.adaptador.repositorio;

import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.modelo.dto.ReservaDto;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.infraestructura.convertidor.reserva.ConvertidorListaReserva;
import com.ceiba.cinemax.infraestructura.convertidor.reserva.factura.ConvertidorFactura;
import com.ceiba.cinemax.infraestructura.entidad.ReservaEntidad;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioReservaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RepositorioReservaPostgreSql implements RepositorioReserva {

    private final RepositorioReservaJpa repositorioReservaJpa;
    private ModelMapper modelMapper= new ModelMapper();
    ConvertidorFactura convertidorFactura = new ConvertidorFactura();

    ConvertidorListaReserva convertidorListaReserva= new ConvertidorListaReserva();

    public RepositorioReservaPostgreSql(RepositorioReservaJpa repositorioReservaJpa) {
        this.repositorioReservaJpa = repositorioReservaJpa;
    }


    @Override
    public void guardar(Reserva reserva) {

        ReservaEntidad reservaEntidad = modelMapper.map(reserva,ReservaEntidad.class);
        reservaEntidad.setFacturaEntidad(convertidorFactura.convertirFacturaDominioAEntidad(reserva.getFactura()));
        repositorioReservaJpa.save(reservaEntidad);
    }

    public List<ReservaDto> listar() {
        List<ReservaEntidad> listReservaEntidad = repositorioReservaJpa.findAll();
        List<ReservaDto> listReserva=new ArrayList<>();
        return convertidorListaReserva.convertirListReservaEntidadAListReserva(listReservaEntidad,listReserva);
    }





}
