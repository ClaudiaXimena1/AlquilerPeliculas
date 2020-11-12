package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
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
		Pelicula pelicula = new Pelicula(null, "Batman", "Accion", "2 horas 15 minutos");

		try {
			crearPeliculaServicio.ejecutar(pelicula);

		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensage));
		}

	}

}
