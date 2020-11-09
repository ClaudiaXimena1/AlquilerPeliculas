package co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CrearClienteServicioTest {

	@Autowired
	CrearClienteServicio crearClienteServicio;

	@Test
	public void validaNoExisteClienteTest() {

		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();

		ClienteDto clienteDto = crearClienteServicio.ejecutar(clienteTestDataBuilder.build());

		assertEquals("Samuel", clienteDto.getNombres());

	}

	@Test
	public void validaExisteClienteTest() {

		final String mensage = "El Cliente ya existe en el sistema";
		Cliente cliente = new Cliente("31274274", "Argenis", "Gomez Grajales", "Calle 8 con 7", "2222222", "3175181818");

		try {
			crearClienteServicio.ejecutar(cliente);

		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensage));
		}

	}

}
