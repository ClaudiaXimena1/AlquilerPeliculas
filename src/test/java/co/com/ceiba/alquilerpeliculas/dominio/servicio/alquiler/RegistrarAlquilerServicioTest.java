package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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

		try {

			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-12"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-13"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals("Batman", alquilerDto.getPeliculaDto().getNombre());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void validaNoExistePeliTest() {
		final String mensage = "La Pelicula no existe en el sistema.";
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Pelicula pelicula = new Pelicula(null, "Titanic", "Drama", "4 horas");

		try {

			alquilerTestDataBuilder.setPelicula(pelicula);
			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-12"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-13"));

			registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensage));
		}

	}

	@Test
	public void validaNoExisteClienteTest() {
		final String mensage = "El Cliente no existe en el sistema.";
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Cliente cliente = new Cliente(null, "1074925262", "Juan Sebastián", "Lozada Bustamante", "Calle 2B con 81",
				"4888686", "3188213131");

		try {

			alquilerTestDataBuilder.setCliente(cliente);
			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-12"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-13"));

			registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensage));
		}

	}

	@Test
	public void validaExisteClienteTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();
		Pelicula pelicula = new Pelicula(null, "Sombra en la Ciudad", "Suspenso", "1 hora 45 minutos");

		try {

			alquilerTestDataBuilder.setPelicula(pelicula);
			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-12"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-13"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals("Lozada Avila", alquilerDto.getClienteDto().getApellidos());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void setFechaAlquilerFindeTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		try {

			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-14"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-16"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals("2020-11-16", dateFormat.format(alquilerDto.getFechaAlquiler()));
			assertEquals("2020-11-18", dateFormat.format(alquilerDto.getFechaEntrega()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void setFechaEntregaFindeTest() {
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		try {

			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-13"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-15"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals("2020-11-13", dateFormat.format(alquilerDto.getFechaAlquiler()));
			assertEquals("2020-11-16", dateFormat.format(alquilerDto.getFechaEntrega()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void calcularValorAlquilerTest() {		
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		try {

			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-14"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-16"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals(5000.00, alquilerDto.getValor());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void calcularValorAlquilerRecargoTest() {		
		AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder();

		try {

			alquilerTestDataBuilder.setFechaAlquiler(dateFormat.parse("2020-11-13"));
			alquilerTestDataBuilder.setFechaEntrega(dateFormat.parse("2020-11-15"));

			AlquilerDto alquilerDto = registrarAlquilerServicio.ejecutar(alquilerTestDataBuilder.build());

			assertEquals(7000.00, alquilerDto.getValor());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
