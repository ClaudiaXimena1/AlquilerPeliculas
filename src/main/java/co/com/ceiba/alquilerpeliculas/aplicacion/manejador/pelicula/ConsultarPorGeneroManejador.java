package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorGeneroServicio;

@Component
public class ConsultarPorGeneroManejador {
	
	private final ConsultarPorGeneroServicio consultaPorGeneroServicio;
	
	public ConsultarPorGeneroManejador(ConsultarPorGeneroServicio consultaPeliculaGeneroServicio) {
		this.consultaPorGeneroServicio = consultaPeliculaGeneroServicio;
	}
	
	@Transactional
	public List<PeliculaDto> ejecutar(String genero){
		return consultaPorGeneroServicio.ejecutar(genero);
	}
	
	

}
