package com.ceiba.cinemax.infraestructura.controlador;
import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoPelicula;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioPelicula;
import com.ceiba.cinemax.dominio.puerto.repositorio.RepositorioSalaCine;
import com.ceiba.cinemax.testdatabuilder.aplicacion.ComandoPeliculaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = CinemaxApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorPeliculaTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioPelicula repositorioPelicula;

    @Autowired
    private RepositorioSalaCine repositorioSalaCine;

    @Autowired
    private MockMvc mockMvc;



    @Test
    void crearPelicula() throws Exception{


        ComandoPelicula comandoPelicula= new ComandoPeliculaTestDataBuilder().build();

        repositorioSalaCine.guardar(comandoPelicula.getSalaCine());

        mockMvc.perform(post("http://localhost:4567/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void crearPeliculaSinSala() throws Exception{


        ComandoPelicula comandoPelicula= new ComandoPeliculaTestDataBuilder().build();

        mockMvc.perform(post("http://localhost:4567/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void listarPeliculaTest() throws Exception{



        SalaCine salaCine1= new SalaCine("1",200,true);
        repositorioSalaCine.guardar(salaCine1);

        Pelicula primeraPelicula= new Pelicula("transformers",salaCine1,"1");
        repositorioPelicula.guardar(primeraPelicula);


        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(primeraPelicula);

        mockMvc.perform(get("http://localhost:4567/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculas)))
                .andDo(print()).andExpect(status().isOk())

                .andExpect(jsonPath("[0].nombre").value("transformers"))
                .andExpect(jsonPath("[0].salaCine.numeroSalaCine").value("1"))
                .andExpect(jsonPath("[0].salaCine.capacidadSillas").value(200))
                .andExpect(jsonPath("[0].salaCine.estadoSalaCine").value(true))
                .andExpect(jsonPath("[0].numeroSalaCine").value("1"));
    }


}
