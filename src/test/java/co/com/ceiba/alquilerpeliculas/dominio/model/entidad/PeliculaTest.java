package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import static org.junit.Assert.fail;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaAtributosObligatorios;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.PeliculaTestDataBuilder;

public class PeliculaTest {	
	
	@Test
	public void validarNombreReqTest() {
		
		final String mensage = "El nombre es un dato obligatorio.";
		
		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		peliculaTestDataBuilder.setNombre(null);
		
		assertThrows(() -> peliculaTestDataBuilder.build(), ValidaAtributosObligatorios.class, mensage);
				
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
