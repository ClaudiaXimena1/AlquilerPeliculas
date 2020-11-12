package co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;

public interface AlquilerRepositorio {
	
	public AlquilerDto registrarAlquiler(Alquiler alquiler);

}
