package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

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
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.PeliculaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CrearPeliculaServicioTest {

	@Autowired
	CrearPeliculaServicio crearPeliculaServicio;

	@Test
	public void validaNoExistePeliTest() {

		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		peliculaTestDataBuilder.setNombre("Salvando al Soldado Ryan");

		PeliculaDto peliculaDto = crearPeliculaServicio.ejecutar(peliculaTestDataBuilder.build());

		assertEquals("Salvando al Soldado Ryan", peliculaDto.getNombre());

	}

	@Test
	public void validaExistePeliTest() {

		final String mensage = "La pelicula ya existe en el sistema";
		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		peliculaTestDataBuilder.setNombre("El Cuaderno de Sara");

		assertThrows(() -> crearPeliculaServicio.ejecutar(peliculaTestDataBuilder.build()),
				ValidaExistenciaExcepcion.class, mensage);

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
