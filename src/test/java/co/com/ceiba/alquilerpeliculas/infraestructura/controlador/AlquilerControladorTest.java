package co.com.ceiba.alquilerpeliculas.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.alquiler.RegistrarAlquilerManejador;
import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.cliente.CrearClienteManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder.AlquilerTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(AlquilerControlador.class)
public class AlquilerControladorTest {

	@Autowired
	private MockMvc mocMvc;

	@MockBean
	private RegistrarAlquilerManejador registrarAlquilerManejador;

	@MockBean
	private CrearClienteManejador crearClienteManejador;

	@Test
	public void registrarAlquiler() {

		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		ClienteDto clienteDto = new ClienteDto("1074925262", "Juan Sebastian", "Lozada Bustamante", "Calle 2B con 81",
				"4888686", "3188213131");
		PeliculaDto peliculaDto = new PeliculaDto("La Purga", "Terror", "1 hora 25 minutos");

		alquilerTestDataBuilder.setClienteDto(clienteDto);
		alquilerTestDataBuilder.setPeliculaDto(peliculaDto);

		try {
			mocMvc.perform(MockMvcRequestBuilders.post("/gestion-alquiler/alquiler")
					.content(asJsonString(alquilerTestDataBuilder)).characterEncoding("UTF-8")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
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
