package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import java.util.List;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class ConsultarPorGeneroServicio {

	private PeliculaRepositorio peliculaRepositorio;

	public ConsultarPorGeneroServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public List<PeliculaDto> ejecutar(String genero) {
		return this.peliculaRepositorio.findByGenero(genero);
	}

}
