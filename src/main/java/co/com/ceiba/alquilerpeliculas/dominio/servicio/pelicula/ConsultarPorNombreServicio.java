package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import java.util.List;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class ConsultarPorNombreServicio {
	
	private PeliculaRepositorio peliculaRepositorio;

	public ConsultarPorNombreServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}
	
	public List<PeliculaDto> ejecutar(String nombre){
		return this.peliculaRepositorio.findByNombre(nombre);
	}

}
