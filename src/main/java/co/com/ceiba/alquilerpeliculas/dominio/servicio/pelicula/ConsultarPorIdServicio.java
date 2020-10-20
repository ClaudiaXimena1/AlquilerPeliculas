package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;


import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class ConsultarPorIdServicio {
	
	private PeliculaRepositorio peliculaRepositorio;

	public ConsultarPorIdServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}
	
	public Pelicula ejecutar(Long id) {
		return this.peliculaRepositorio.findById(id);
	}

}
