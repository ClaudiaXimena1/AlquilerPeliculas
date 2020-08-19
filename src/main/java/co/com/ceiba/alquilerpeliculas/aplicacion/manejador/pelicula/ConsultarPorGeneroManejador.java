package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.PeliculaServicio;

@Component
public class ConsultarPorGeneroManejador {
	
	private final PeliculaServicio peliculaServicio;
	
	@Autowired
	public ConsultarPorGeneroManejador(PeliculaServicio peliculaServicio) {
		this.peliculaServicio = peliculaServicio;
	}
	
	public List<PeliculaDto> ejecutar(String genero){
		return peliculaServicio.consultaPorGenero(genero);
	}
	
	

}
