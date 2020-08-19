package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan("co.com.ceiba")
public class PeliculaControladorTest {
	
	@Autowired
    private MockMvc mocMvc;
	
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

	
	@Test
	public void crearPeliculaTest() {
		
		PeliculaDto peliculaDto = new PeliculaTestDataBuilder().build();
		
		try {
			mocMvc.perform( MockMvcRequestBuilders
				      .post("/Peliculas/crearPelicula")
				      .content(asJsonString(peliculaDto))
				      .characterEncoding("UTF-8")
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isCreated());
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
