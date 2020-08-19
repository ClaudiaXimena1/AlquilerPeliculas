package co.com.ceiba.alquilerpeliculas.dominio.servicio;

import java.util.List;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class PeliculaServicio {

	private PeliculaRepositorio peliculaRepositorio;

	public PeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public PeliculaDto crear(Pelicula pelicula) {
		return this.peliculaRepositorio.save(pelicula);
	}

	public PeliculaDto actualizar(Pelicula pelicula) {
		return this.peliculaRepositorio.save(pelicula);
	}

	public List<PeliculaDto> consultaPorGenero(String genero) {
		return this.peliculaRepositorio.findByGenero(genero);
	}

	public List<PeliculaDto> consultaPorNombre(String nombre) {
		return this.peliculaRepositorio.findByNombre(nombre);
	}
	
	public Pelicula consultaPorId(Long id) {
		return this.peliculaRepositorio.findById(id);
	}

}
