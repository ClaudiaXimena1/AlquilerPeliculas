package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import static org.junit.Assert.fail;

import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaAtributosObligatorios;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.ClienteTestDataBuilder;

public class ClienteTest {
	
	@Test
	public void validarIdentificacionReqTest() {
		
		final String mensage = "La Identificacion es un dato obligatorio.";
		
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.setIdentificacion(null);
		
		assertThrows(() -> clienteTestDataBuilder.build(), ValidaAtributosObligatorios.class, mensage);
				
	}
	
	@Test
	public void validarDireccionReqTest() {
		
		final String mensage = "La Direccion es un dato obligatorio.";
		
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.setDireccion(null);
		
		assertThrows(() -> clienteTestDataBuilder.build(), ValidaAtributosObligatorios.class, mensage);
				
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
