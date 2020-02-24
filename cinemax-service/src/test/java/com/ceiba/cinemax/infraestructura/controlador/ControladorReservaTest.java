package com.ceiba.cinemax.infraestructura.controlador;
import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;
import com.ceiba.cinemax.dominio.modelo.Factura;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioPeliculaPostgreSql;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioReservaPostgreSql;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioSalaCinePostgreSql;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioPeliculaJpa;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioReservaJpa;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioSalaCineJpa;
import com.ceiba.cinemax.testdatabuilder.aplicacion.ComandoReservaTestDataBuilder;
import com.ceiba.cinemax.testdatabuilder.dominio.modelo.FacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = CinemaxApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorReservaTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioPeliculaJpa repositorioPeliculaJpa;

    @Autowired
    private RepositorioSalaCineJpa repositorioSalaCineJpa;

    @Autowired
    private RepositorioReservaJpa repositorioReservaJpa;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearReserva() throws Exception {

        ComandoReserva comandoReserva = new ComandoReservaTestDataBuilder().build();

        SalaCine salaCine = new SalaCine("1", 300, true);
        RepositorioSalaCinePostgreSql repositorioSalaCinePostgreSql = new RepositorioSalaCinePostgreSql(repositorioSalaCineJpa);
        repositorioSalaCinePostgreSql.guardar(salaCine);

        Pelicula pelicula = new Pelicula("Transformers", salaCine, "1");
        RepositorioPeliculaPostgreSql repositorioPeliculaPostgreSql = new RepositorioPeliculaPostgreSql(repositorioPeliculaJpa);
        repositorioPeliculaPostgreSql.guardar(pelicula);

        mockMvc.perform(post("http://localhost:8080/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoReserva))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void listarReservaTest() throws Exception {

        RepositorioPeliculaPostgreSql repositorioPeliculaPostgreSql = new RepositorioPeliculaPostgreSql(repositorioPeliculaJpa);
        RepositorioSalaCinePostgreSql repositorioSalaCinePostgreSql = new RepositorioSalaCinePostgreSql(repositorioSalaCineJpa);
        RepositorioReservaPostgreSql repositorioReservaPostgreSql= new RepositorioReservaPostgreSql(repositorioReservaJpa);


        SalaCine salaCine1 = new SalaCine("1", 200, true);
        repositorioSalaCinePostgreSql.guardar(salaCine1);

        Pelicula primeraPelicula = new Pelicula("transformers", salaCine1, salaCine1.getNumeroSalaCine());
        repositorioPeliculaPostgreSql.guardar(primeraPelicula);

//        Factura factura=new Factura(LocalDate.of(2020,02,27),21000);
        Reserva reserva = new Reserva(1L, LocalDate.of(2020, 02, 27), 1037854939, "Santiago", 3, primeraPelicula.getNombre(), new FacturaTestDataBuilder().build());
        repositorioReservaPostgreSql.guardar(reserva);



        mockMvc.perform(get("http://localhost:8080/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print()).andExpect(status().isOk())

               // .andExpect(jsonPath("[0].idReserva").value(1))
                .andExpect(jsonPath("[0].fechaReservaPelicula").value(LocalDate.of(2020, 02, 27).toString()))
                .andExpect(jsonPath("[0].documentoCliente").value(1037854939))
                .andExpect(jsonPath("[0].nombreCliente").value("Santiago"))
                .andExpect(jsonPath("[0].cantidadPuestos").value(3))
                .andExpect(jsonPath("[0].nombrePelicula").value("transformers"));
//                .andExpect(jsonPath("[0].factura.fechaReserva").value(LocalDate.of(2020,02,27)))
//                .andExpect(jsonPath("[0].factura.valor").value(21000));


    }
}