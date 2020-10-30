package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

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
public class ConsultarPorGeneroServicioTest {

	@Autowired
	ConsultarPorGeneroServicio consultarPorGeneroServicio;

	@Test
	public void ejecutarTest() {
		String genero = "Accion";
		PeliculaDto peliculaDto = new PeliculaDto("Batman", "Accion", "2 horas 15 minutos");
		List<PeliculaDto> resultPeliculas = new ArrayList<PeliculaDto>();
		resultPeliculas.add(peliculaDto);

		List<PeliculaDto> peliculasGenero = consultarPorGeneroServicio.ejecutar(genero);

		assertEquals(resultPeliculas.get(0).getNombre(), peliculasGenero.get(0).getNombre());
	}

}
