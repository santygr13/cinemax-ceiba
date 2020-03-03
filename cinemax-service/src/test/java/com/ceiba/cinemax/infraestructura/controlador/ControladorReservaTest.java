package com.ceiba.cinemax.infraestructura.controlador;
import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;

import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.Reserva;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
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
    private RepositorioPelicula repositorioPelicula;

    @Autowired
    private RepositorioSalaCine repositorioSalaCine;

    @Autowired
    private RepositorioReserva repositorioReserva;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearReserva() throws Exception {

        ComandoReserva comandoReserva = new ComandoReservaTestDataBuilder().build();

        SalaCine salaCine = new SalaCine("1", 300, true);
        repositorioSalaCine.guardar(salaCine);

        Pelicula pelicula = new Pelicula("Transformers", salaCine, "1");
        repositorioPelicula.guardar(pelicula);

        mockMvc.perform(post("http://localhost:4567/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoReserva))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void listarReservaTest() throws Exception {

        SalaCine salaCine1 = new SalaCine("1", 200, true);
        repositorioSalaCine.guardar(salaCine1);

        Pelicula primeraPelicula = new Pelicula("transformers", salaCine1, salaCine1.getNumeroSalaCine());
        repositorioPelicula.guardar(primeraPelicula);


        Reserva reserva = new Reserva(1L, LocalDate.of(2020, 03, 27), 1037854939, "Santiago", 3, primeraPelicula.getNombre(), new FacturaTestDataBuilder().build());
        repositorioReserva.guardar(reserva);


        mockMvc.perform(get("http://localhost:4567/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print()).andExpect(status().isOk())


                .andExpect(jsonPath("[0].fechaReservaPelicula").value(LocalDate.of(2020, 03, 27).toString()))
                .andExpect(jsonPath("[0].documentoCliente").value(1037854939))
                .andExpect(jsonPath("[0].nombreCliente").value("Santiago"))
                .andExpect(jsonPath("[0].cantidadPuestos").value(3))
                .andExpect(jsonPath("[0].nombrePelicula").value("transformers"));


    }
}