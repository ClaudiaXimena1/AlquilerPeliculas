package co.com.ceiba.alquilerpeliculas.aplicacion.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.PeliculaServicio;

@Configuration
public class BeanConfig {

	@Bean
	public PeliculaServicio getPeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		return new PeliculaServicio(peliculaRepositorio);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
