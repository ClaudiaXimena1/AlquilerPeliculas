package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class ActualizarPeliculaServicio {

	private PeliculaRepositorio peliculaRepositorio;

	private static final String LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA = "La pelicula no existe en el sistema";

	public ActualizarPeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public PeliculaDto ejecutar(Pelicula pelicula) {
		Boolean existe = validaExistePeli(pelicula.getId());

		if (Boolean.FALSE.equals(existe)) {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA);
		}
		
		return this.peliculaRepositorio.save(pelicula);
	}

	private Boolean validaExistePeli(Long id) {
		Pelicula pelicula = peliculaRepositorio.findById(id);
		Boolean existe = true;

		if (pelicula == null) {
			existe = false;
		}
		return existe;
	}

}
