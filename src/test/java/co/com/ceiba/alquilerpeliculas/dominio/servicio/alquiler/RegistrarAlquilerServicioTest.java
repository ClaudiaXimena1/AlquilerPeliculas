package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.AlquilerTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RegistrarAlquilerServicioTest {

	@Autowired
	RegistrarAlquilerServicio registrarAlquilerServicio;

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void validaExistePeliTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Pelicula pelicula = new Pelicula(null, "Orgullo y Prejuicio", "Romance", "2 horas 15 minutos");

		alquilerTestDataBuilder.setPelicula(pelicula);
		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-12"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-13"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals("Orgullo y Prejuicio", alquilerDto.getPeliculaDto().getNombre());

	}

	@Test
	public void validaNoExistePeliTest() {
		final String mensage = "La Pelicula no existe en el sistema.";
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Pelicula pelicula = new Pelicula(null, "Buscando a Nemo", "Drama", "4 horas");

		alquilerTestDataBuilder.setPelicula(pelicula);
		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-12"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-13"));

		assertThrows(() -> registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build()),
				ValidaExistenciaExcepcion.class, mensage);

	}

	@Test
	public void validaNoExisteClienteTest() {
		final String mensage = "El Cliente no existe en el sistema.";
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Cliente cliente = new Cliente(null, "1074925262", "Juan Sebastian", "Lozada Bustamante", "Calle 2B con 81",
				"4888686", "3188213131");

		alquilerTestDataBuilder.setCliente(cliente);
		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-12"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-13"));

		assertThrows(() -> registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build()),
				ValidaExistenciaExcepcion.class, mensage);

	}

	@Test
	public void validaExisteClienteTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Pelicula pelicula = new Pelicula(null, "Sombra en la Ciudad", "Suspenso", "1 hora 45 minutos");

		alquilerTestDataBuilder.setPelicula(pelicula);
		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-12"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-13"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals("Lozada Avila", alquilerDto.getClienteDto().getApellidos());

	}

	@Test
	public void setFechaAlquilerFindeTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-14"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-16"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals("2020-11-16", dateFormat.format(alquilerDto.getFechaAlquiler()));
		assertEquals("2020-11-18", dateFormat.format(alquilerDto.getFechaEntrega()));

	}

	@Test
	public void setFechaEntregaFindeTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-13"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-15"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals("2020-11-13", dateFormat.format(alquilerDto.getFechaAlquiler()));
		assertEquals("2020-11-16", dateFormat.format(alquilerDto.getFechaEntrega()));

	}

	@Test
	public void calcularValorAlquilerTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-14"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-16"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals(5000.00, alquilerDto.getValor());

	}

	@Test
	public void calcularValorAlquilerRecargoTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		alquilerTestDataBuilder.setFechaAlquiler(convertirFecha("2020-11-13"));
		alquilerTestDataBuilder.setFechaEntrega(convertirFecha("2020-11-15"));

		AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		assertEquals(7000.00, alquilerDto.getValor());

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

	private Date convertirFecha(String fecha) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaRetorna = null;

		try {
			fechaRetorna = dateFormat.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fechaRetorna;

	}

}
