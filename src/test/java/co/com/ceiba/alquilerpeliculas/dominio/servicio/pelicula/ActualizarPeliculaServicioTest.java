package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.PeliculaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ActualizarPeliculaServicioTest {
	
	@Autowired
	private ActualizarPeliculaServicio actualizarPeliculaServicio;
	
	@Test
	public void validaExistePeliTest() {

		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		
		PeliculaDto peliculaDto = actualizarPeliculaServicio.ejecutar(peliculaTestDataBuilder.build());
		
		assertEquals("3 horas 50 minutos", peliculaDto.getDuracion());
		
	}

}
