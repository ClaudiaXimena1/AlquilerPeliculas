package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.alquiler;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler.RegistrarAlquilerServicio;
import co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity.factory.AlquilerFactory;

@Component
public class RegistrarAlquilerManejador {
	
	private RegistrarAlquilerServicio registrarAlquilerServicio;
	
	public RegistrarAlquilerManejador(RegistrarAlquilerServicio registrarAlquilerServicio) {
		this.registrarAlquilerServicio = registrarAlquilerServicio;
	}
	
	public AlquilerDto ejecutar(AlquilerDto alquilerDto) {
		Alquiler alquiler = AlquilerFactory.toEntidad(alquilerDto);
		
		return registrarAlquilerServicio.ejecutar(alquiler);
		
	}

}
