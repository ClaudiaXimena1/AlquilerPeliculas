package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ActualizarPeliculaServicio;

@Component
public class ActualizarPeliculaManejador {

	private final ActualizarPeliculaServicio updPeliculaServicio;

	@Autowired
	public ActualizarPeliculaManejador(ActualizarPeliculaServicio peliculaServicio) {
		this.updPeliculaServicio = peliculaServicio;
	}

	public PeliculaDto ejecutar(Pelicula pelicula) {
		return updPeliculaServicio.ejecutar(pelicula);
	}

}
