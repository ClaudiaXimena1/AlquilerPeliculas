package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ComparaAtributosExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaAtributosObligatorios;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.AlquilerTestDataBuilder;

public class AlquilerTest {

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void validarFechaAlquilerReqTest() {

		final String mensage = "La Fecha de Alquiler es un dato obligatorio.";

		try {

			AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
			alquilerTestDataBuilder.setFechaAlquiler(null);
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-13"));

			assertThrows(() -> alquilerTestDataBuilder.build(), ValidaAtributosObligatorios.class, mensage);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void validarFechaEntregaReqTest() {

		final String mensage = "La Fecha de Entrega es un dato obligatorio.";

		try {

			AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-12"));
			alquilerTestDataBuilder.setFechaEntrega(null);

			assertThrows(() -> alquilerTestDataBuilder.build(), ValidaAtributosObligatorios.class, mensage);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void validarDifFechasTest() {

		final String mensage = "La Fecha de Entrega debe ser mayor a la Fecha de Alquiler.";

		try {

			AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-16"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-14"));

			assertThrows(() -> alquilerTestDataBuilder.build(), ComparaAtributosExcepcion.class, mensage);

		} catch (ParseException e) {
			e.printStackTrace();
		}

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
