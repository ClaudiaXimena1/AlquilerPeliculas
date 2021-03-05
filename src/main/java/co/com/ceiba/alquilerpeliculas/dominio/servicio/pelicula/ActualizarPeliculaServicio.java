package co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class ActualizarPeliculaServicio {

	private PeliculaRepositorio peliculaRepositorio;

	private static final String LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA = "La pelicula no existe en el sistema";
	private static final String LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA_CON_IGUAL_NOMBRE = "El nombre de La pelicula ya existe para otra pelicula";

	public ActualizarPeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public PeliculaDto ejecutar(Pelicula pelicula) {
		Boolean existe = validaExistePeli(pelicula.getId());
		Boolean existeNombre =  validaExistePeliNombre(pelicula.getNombre(), pelicula.getId());

		if (Boolean.FALSE.equals(existe)) {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA);
		}
		
		if (Boolean.TRUE.equals(existeNombre)) {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA_CON_IGUAL_NOMBRE);
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
	
	private Boolean validaExistePeliNombre(String nombre, Long id) {
		Long idPelicula = peliculaRepositorio.findIdByNombre(nombre);
		Boolean existe = false;

		if (idPelicula != null && !idPelicula.equals(id)) {
			existe = true;
		}
		return existe;
	}

}
