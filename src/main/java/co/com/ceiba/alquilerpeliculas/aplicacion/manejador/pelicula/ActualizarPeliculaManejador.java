package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.PeliculaServicio;

@Component
public class ActualizarPeliculaManejador {
	
	private final PeliculaServicio peliculaServicio;
	
	@Autowired
	public ActualizarPeliculaManejador(PeliculaServicio peliculaServicio) {
		this.peliculaServicio = peliculaServicio;
	}
	
	public PeliculaDto ejecutar(Pelicula pelicula) {
		return peliculaServicio.actualizar(pelicula);
	}

}
