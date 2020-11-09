package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import java.util.List;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class CrearPeliculaServicio {

	private PeliculaRepositorio peliculaRepositorio;

	private static final String LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA = "La pelicula ya existe en el sistema";

	public CrearPeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public PeliculaDto ejecutar(Pelicula pelicula) {
		Boolean existe = validaExistePeli(pelicula.getNombre());

		if (Boolean.TRUE.equals(existe)) {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA);
		}
		return this.peliculaRepositorio.save(pelicula);
	}

	private Boolean validaExistePeli(String nombre) {
		List<PeliculaDto> peliculas = peliculaRepositorio.findByNombre(nombre);
		Boolean existe = false;
		Integer contador = 0;
		int i;

		for (i = 0; i < peliculas.size(); i++) {
			contador++;
		}

		if (contador > 0) {
			existe = true;
		}
		return existe;
	}

}
