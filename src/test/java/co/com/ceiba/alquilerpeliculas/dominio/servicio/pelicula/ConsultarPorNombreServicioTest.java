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
public class ConsultarPorNombreServicioTest {
	
	@Autowired
	ConsultarPorNombreServicio consultarPorNombreServicio;
	
	@Test
	public void ejecutarTest() {
		String nombre = "El Cuaderno de Sara";
		PeliculaDto peliculaDto = new PeliculaDto("El Cuaderno de Sara", "Drama", "2 horas 10 minutos");
		List<PeliculaDto> resultPeliculas = new ArrayList<PeliculaDto>();
		resultPeliculas.add(peliculaDto);

		List<PeliculaDto> peliculasNombre = consultarPorNombreServicio.ejecutar(nombre);

		assertEquals(resultPeliculas.get(0).getNombre(), peliculasNombre.get(0).getNombre());
	}

}
