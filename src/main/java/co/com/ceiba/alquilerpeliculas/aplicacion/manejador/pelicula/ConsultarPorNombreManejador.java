package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorNombreServicio;

@Component
public class ConsultarPorNombreManejador {

	private final ConsultarPorNombreServicio consultaPeliculaPorNombreServicio;

	@Autowired
	public ConsultarPorNombreManejador(ConsultarPorNombreServicio consultaPeliculaPorNombreServicio) {
		this.consultaPeliculaPorNombreServicio = consultaPeliculaPorNombreServicio;
	}

	public List<PeliculaDto> ejecutar(String nombre) {
		return consultaPeliculaPorNombreServicio.ejecutar(nombre);
	}

}
