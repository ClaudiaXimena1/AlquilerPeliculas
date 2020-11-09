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

import co.com.ceiba.alquilerpeliculas.aplicacion.manejador.cliente.CrearClienteManejador;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteControlador.class)
public class ClienteControladorTest {

	@Autowired
	private MockMvc mocMvc;
	
	@MockBean
	private CrearClienteManejador crearClienteManejador;

	@Test
	public void crearCliente() {

		ClienteDto clienteDto = new ClienteTestDataBuilder().build();

		try {
			mocMvc.perform(MockMvcRequestBuilders.post("/gestion-clientes/clientes").content(asJsonString(clienteDto))
					.characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
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
