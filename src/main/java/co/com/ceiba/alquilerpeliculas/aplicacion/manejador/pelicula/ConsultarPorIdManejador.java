package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorIdServicio;

@Component
public class ConsultarPorIdManejador {
	
	private final ConsultarPorIdServicio consultaPeliculaPorIdServicio;

	public ConsultarPorIdManejador(ConsultarPorIdServicio consultaPeliculaPorIdServicio) {
		this.consultaPeliculaPorIdServicio = consultaPeliculaPorIdServicio;
	}
	
	@Transactional
	public Pelicula ejecutar(Long id) {
		return consultaPeliculaPorIdServicio.ejecutar(id);
	}

}
