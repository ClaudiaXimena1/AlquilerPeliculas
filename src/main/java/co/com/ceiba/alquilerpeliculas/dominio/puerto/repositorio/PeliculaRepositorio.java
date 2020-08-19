package co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio;

import java.util.List;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;

public interface PeliculaRepositorio {
	
	public PeliculaDto save(Pelicula pelicula);
	
	public List<PeliculaDto> findByGenero(String genero);
	
	public List<PeliculaDto> findByNombre(String nombre);
	
	public Pelicula findById(Long id);

}
