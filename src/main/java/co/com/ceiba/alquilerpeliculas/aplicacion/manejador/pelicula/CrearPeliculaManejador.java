package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.CrearPeliculaServicio;

@Component
public class CrearPeliculaManejador {
	
	private final CrearPeliculaServicio crearPeliculaServicio;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public CrearPeliculaManejador(CrearPeliculaServicio crearPeliculaServicio) {
		this.crearPeliculaServicio = crearPeliculaServicio;
	}
	
	public PeliculaDto ejecutar(PeliculaDto peliculaDto) {
		Pelicula pelicula = modelMapper.map(peliculaDto, Pelicula.class);
		return crearPeliculaServicio.ejecutar(pelicula);
	}

}
