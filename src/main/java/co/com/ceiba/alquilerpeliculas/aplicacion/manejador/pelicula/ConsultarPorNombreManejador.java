package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorNombreServicio;

@Component
public class ConsultarPorNombreManejador {

	private final ConsultarPorNombreServicio consultaPeliculaPorNombreServicio;

	public ConsultarPorNombreManejador(ConsultarPorNombreServicio consultaPeliculaPorNombreServicio) {
		this.consultaPeliculaPorNombreServicio = consultaPeliculaPorNombreServicio;
	}
	
	@Transactional
	public List<PeliculaDto> ejecutar(String nombre) {
		return consultaPeliculaPorNombreServicio.ejecutar(nombre);
	}

}
