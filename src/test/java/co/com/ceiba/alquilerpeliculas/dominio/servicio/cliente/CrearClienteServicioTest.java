package co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
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
		Cliente cliente = new Cliente(null, "31274274", "Argenis", "Gomez Grajales", "Calle 8 con 7", "2222222", "3175181818");

		assertThrows(() -> crearClienteServicio.ejecutar(cliente), ValidaExistenciaExcepcion.class, mensage);

	}
	
	private static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
		try {
			supplier.get();
			fail();
		} catch (Exception e) {
			Assert.assertTrue("Se esperaba la excepcion" + exception.getCanonicalName() + "pero fue lanzada"
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

}
