package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
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
public class ActualizarPeliculaServicioTest {
	
	@Autowired
	private ActualizarPeliculaServicio actualizarPeliculaServicio;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Test
	public void validaExistePeliTest() {

		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		peliculaTestDataBuilder.setId((long) 3);
		
		PeliculaDto peliculaDto = actualizarPeliculaServicio.ejecutar(peliculaTestDataBuilder.build());
		
		assertEquals("3 horas 50 minutos", peliculaDto.getDuracion());
		
	}
	
	@Test
	public void validaExistePeli2Test() {

		Pelicula pelicula = new Pelicula((long) 1, "El Cuaderno de Sara", "Drama", "2 horas 10 minutos");
		
		PeliculaDto peliculaDto = actualizarPeliculaServicio.ejecutar(pelicula);
		
		assertNotNull(peliculaDto);
		
	}
	
	@Test
	public void validaNoExistePeliTest() {
		
		final String mensage = "La pelicula no existe en el sistema";
		PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder();
		peliculaTestDataBuilder.setId((long) 4);
		
		try {
			actualizarPeliculaServicio.ejecutar(peliculaTestDataBuilder.build());
			
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensage));
		}	

		
	}

}
