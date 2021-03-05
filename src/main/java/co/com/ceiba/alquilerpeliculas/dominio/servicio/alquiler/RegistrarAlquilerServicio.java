package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class RegistrarAlquilerServicio {

	private AlquilerRepositorio alquilerRepositorio;
	private ClienteRepositorio clienteRepositorio;
	private PeliculaRepositorio peliculaRepositorio;

	private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El Cliente no existe en el sistema.";
	private static final String LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA = "La Pelicula no existe en el sistema.";

	public RegistrarAlquilerServicio(AlquilerRepositorio alquilerRepositorio, ClienteRepositorio clienteRepositorio,
			PeliculaRepositorio peliculaRepositorio) {
		this.alquilerRepositorio = alquilerRepositorio;
		this.clienteRepositorio = clienteRepositorio;
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public AlquilerDto ejecutar(Alquiler alquiler) {
		Long idPelicula = validaExistePeli(alquiler.getPelicula().getNombre());
		Long idCliente = validaExisteCliente(alquiler.getCliente().getIdentificacion());

		if (idCliente == null) {
			throw new ValidaExistenciaExcepcion(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
		}

		if (idPelicula == null) {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA);
		}

		Cliente cliente = clienteRepositorio.findById(idCliente);
		alquiler.setCliente(cliente);
		Pelicula pelicula = peliculaRepositorio.findById(idPelicula);
		alquiler.setPelicula(pelicula);

		return this.alquilerRepositorio.registrarAlquiler(alquiler);
	}

	private Long validaExistePeli(String nombre) {
		Long idPelicula = peliculaRepositorio.findIdByNombre(nombre);

		if (idPelicula == null) {
			return null;
		}
		return idPelicula;
	}

	private Long validaExisteCliente(String identificacion) {
		Long idCliente = clienteRepositorio.findIdByIdentificacion(identificacion);

		if (idCliente == null) {
			return null;
		}
		return idCliente;
	}

}
