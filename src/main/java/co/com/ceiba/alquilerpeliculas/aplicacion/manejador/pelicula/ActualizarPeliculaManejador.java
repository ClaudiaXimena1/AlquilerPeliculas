package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ActualizarPeliculaServicio;

@Component
public class ActualizarPeliculaManejador {

	private final ActualizarPeliculaServicio actualizaPeliculaServicio;

	public ActualizarPeliculaManejador(ActualizarPeliculaServicio peliculaServicio) {
		this.actualizaPeliculaServicio = peliculaServicio;
	}
	
	@Transactional
	public PeliculaDto ejecutar(Pelicula pelicula) {
		return actualizaPeliculaServicio.ejecutar(pelicula);
	}

}
