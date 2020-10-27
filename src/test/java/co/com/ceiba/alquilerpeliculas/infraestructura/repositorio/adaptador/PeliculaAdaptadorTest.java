package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PeliculaAdaptadorTest {
	
	@Autowired
	PeliculaAdaptador peliculaAdaptador;
	
	@Test
	public void findByGeneroTest() {
		String genero = "Suspenso";
		
		List<PeliculaDto> peliculas = peliculaAdaptador.findByGenero(genero);
		
		assertEquals("Sombra en la Ciudad", peliculas.get(0).getNombre());
		
	}
	
	@Test
	public void findByNombreTest() {
		String nombre = "Batman";
		
		List<PeliculaDto> peliculas = peliculaAdaptador.findByNombre(nombre);
		
		assertEquals("Batman", peliculas.get(0).getNombre());
		assertEquals("2 horas 15 minutos", peliculas.get(0).getDuracion());
		
	}

}
