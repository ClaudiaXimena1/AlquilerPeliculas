package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;

public class RegistrarAlquilerServicio {
	
	private AlquilerRepositorio alquilerRepositorio;

	public RegistrarAlquilerServicio(AlquilerRepositorio alquilerRepositorio) {
		this.alquilerRepositorio = alquilerRepositorio;
	}
	
	public void ejecutar(Alquiler alquiler) {
		this.alquilerRepositorio.registrarAlquiler(alquiler);
	}

}
