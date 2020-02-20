package com.ceiba.cinemax.infraestructura.controlador;
import com.ceiba.cinemax.CinemaxApplication;
import com.ceiba.cinemax.aplicacion.comando.ComandoReserva;
import com.ceiba.cinemax.dominio.modelo.Pelicula;
import com.ceiba.cinemax.dominio.modelo.SalaCine;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioPeliculaPostgreSql;
import com.ceiba.cinemax.infraestructura.adaptador.repositorio.RepositorioSalaCinePostgreSql;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioPeliculaJpa;
import com.ceiba.cinemax.infraestructura.repositoriojpa.RepositorioSalaCineJpa;
import com.ceiba.cinemax.testdatabuilder.aplicacion.ComandoReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    private MockMvc mockMvc;

    @Test
    public void crearReserva() throws Exception {

        ComandoReserva comandoReserva = new ComandoReservaTestDataBuilder().build();

        SalaCine salaCine = new SalaCine("1", 300, true);
        RepositorioSalaCinePostgreSql repositorioSalaCinePostgreSql = new RepositorioSalaCinePostgreSql(repositorioSalaCineJpa);
        repositorioSalaCinePostgreSql.guardar(salaCine);

        Pelicula pelicula = new Pelicula( "Transformers",salaCine, "1");
        RepositorioPeliculaPostgreSql repositorioPeliculaPostgreSql = new RepositorioPeliculaPostgreSql(repositorioPeliculaJpa);
        repositorioPeliculaPostgreSql.guardar(pelicula);

        mockMvc.perform(post("http://localhost:8080/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoReserva))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }








}