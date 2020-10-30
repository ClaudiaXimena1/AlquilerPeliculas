package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder.PeliculaTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConsultarPorIdServicioTest {
	
	@Autowired
	ConsultarPorIdServicio consultarPorIdServicio;
	
	@Test
	public void ejecutarTest() {
		Long id = (long) 3;
		
		Pelicula pelicula = new PeliculaTestDataBuilder().build();
		pelicula.setNombre("Batman");
		
		Pelicula peliculaResul = consultarPorIdServicio.ejecutar(id);
		
		assertEquals(pelicula.getNombre(), peliculaResul.getNombre());
		
	}

}
