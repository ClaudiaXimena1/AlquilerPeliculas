package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.CrearPeliculaServicio;

@Component
public class CrearPeliculaManejador {

	private final CrearPeliculaServicio crearPeliculaServicio;

	public CrearPeliculaManejador(CrearPeliculaServicio crearPeliculaServicio) {
		this.crearPeliculaServicio = crearPeliculaServicio;
	}

	public PeliculaDto ejecutar(PeliculaDto peliculaDto) {
		Pelicula pelicula = new Pelicula(null, peliculaDto.getNombre(), peliculaDto.getGenero(),
				peliculaDto.getDuracion());
		return crearPeliculaServicio.ejecutar(pelicula);
	}

}
