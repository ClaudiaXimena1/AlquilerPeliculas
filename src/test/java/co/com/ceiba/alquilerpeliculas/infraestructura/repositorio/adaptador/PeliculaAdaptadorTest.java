package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
		PeliculaDto peliculaDto = new PeliculaDto("Sombra en la Ciudad", "Suspenso", "1 hora 45 minutos");
		List<PeliculaDto> resultPeliculas = new ArrayList<PeliculaDto>();
		resultPeliculas.add(peliculaDto);

		List<PeliculaDto> peliculasGenero = peliculaAdaptador.findByGenero(genero);

		assertEquals(resultPeliculas.get(0).getNombre(), peliculasGenero.get(0).getNombre());

	}

	@Test
	public void findByNombreTest() {
		String nombre = "Sombra en la Ciudad";
		PeliculaDto peliculaDto = new PeliculaDto("Sombra en la Ciudad", "Suspenso", "1 hora 45 minutos");
		List<PeliculaDto> resultPeliculas = new ArrayList<PeliculaDto>();
		resultPeliculas.add(peliculaDto);

		List<PeliculaDto> peliculasNombre = peliculaAdaptador.findByNombre(nombre);

		assertEquals(resultPeliculas.get(0).getNombre(), peliculasNombre.get(0).getNombre());

	}

}
