package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ActualizarPeliculaManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorGeneroManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorIdManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.ConsultarPorNombreManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula.CrearPeliculaManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;
import co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder.PeliculaTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(PeliculaControlador.class)
public class PeliculaControladorTest {

	@MockBean
	private CrearPeliculaManejador crearPeliculaManejador;

	@MockBean
	private ActualizarPeliculaManejador actualizarPeliculaManejador;

	@MockBean
	private ConsultarPorGeneroManejador consultarPorGeneroManejador;

	@MockBean
	private ConsultarPorNombreManejador consultarPorNombreManejador;

	@MockBean
	private ConsultarPorIdManejador consultarPorIdManejador;

	@MockBean
	private PeliculaRepositorio peliculaRepositorio;
	
	@MockBean
	private ModelMapper modelMapper;
	
	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crearPeliculaTest() {

		PeliculaDto peliculaDto = new PeliculaTestDataBuilder().build();

		try {
			mocMvc.perform(MockMvcRequestBuilders.post("/gestion-peliculas/peliculas").content(asJsonString(peliculaDto))
					.characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void consultarPeliGeneroTest() {
		List<PeliculaDto> peliculaDto = Arrays
				.asList(new PeliculaDto("Sombra en la Ciudad", "Suspenso", "1 hora 45 minutos"));

		when(this.consultarPorGeneroManejador.ejecutar("Suspenso")).thenReturn((peliculaDto));

		try {
			mocMvc.perform(get("/gestion-peliculas/peliculas/genero/Suspenso"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$[0].nombre", is("Sombra en la Ciudad")))
					.andExpect(jsonPath("$[0].genero", is("Suspenso"))).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void consultarPeliNombreTest() {
		List<PeliculaDto> peliculaDto = Arrays
				.asList(new PeliculaDto("El Cuaderno de Sara", "Drama", "2 horas 10 minutos"));

		when(this.consultarPorNombreManejador.ejecutar("Cuaderno")).thenReturn((peliculaDto));

		try {
			mocMvc.perform(get("/gestion-peliculas/peliculas/nombre/Cuaderno"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$[0].nombre", is("El Cuaderno de Sara")))
					.andExpect(jsonPath("$[0].genero", is("Drama"))).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void actualizarPeliculaTest() {
		Long id = (long) 1;
		PeliculaDto peliculaDto = new PeliculaDto("El Cuaderno de Sara", "Drama", "2 horas 20 minutos");
		
		try {
			mocMvc.perform(MockMvcRequestBuilders.put("/gestion-peliculas/peliculas/{id}", id).content(asJsonString(peliculaDto))
					.characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
