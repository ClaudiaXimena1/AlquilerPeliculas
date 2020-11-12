package co.com.ceiba.alquilerpeliculas.infraestructura.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler.RegistrarAlquilerServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.cliente.CrearClienteServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ActualizarPeliculaServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorGeneroServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorIdServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.ConsultarPorNombreServicio;
import co.com.ceiba.alquilerpeliculas.dominio.servicio.pelicula.CrearPeliculaServicio;

@Configuration
public class ConfiguracionBean {

	@Bean
	public ActualizarPeliculaServicio getActualizarPeliServicio(PeliculaRepositorio peliculaRepositorio) {
		return new ActualizarPeliculaServicio(peliculaRepositorio);
	}

	@Bean
	public ConsultarPorGeneroServicio getConsultarPorGeneroServicio(PeliculaRepositorio peliculaRepositorio) {
		return new ConsultarPorGeneroServicio(peliculaRepositorio);
	}

	@Bean
	public ConsultarPorIdServicio getConsultarPorIdServicio(PeliculaRepositorio peliculaRepositorio) {
		return new ConsultarPorIdServicio(peliculaRepositorio);
	}

	@Bean
	public ConsultarPorNombreServicio getConsultarPorNombreServicio(PeliculaRepositorio peliculaRepositorio) {
		return new ConsultarPorNombreServicio(peliculaRepositorio);
	}

	@Bean
	public CrearPeliculaServicio getCrearPeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
		return new CrearPeliculaServicio(peliculaRepositorio);
	}

	@Bean
	public RegistrarAlquilerServicio getCrearAlquilerServicio(AlquilerRepositorio alquilerRepositorio,
			ClienteRepositorio clienteRepositorio, PeliculaRepositorio peliculaRepositorio) {
		return new RegistrarAlquilerServicio(alquilerRepositorio, clienteRepositorio, peliculaRepositorio);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CrearClienteServicio getClienteServicio(ClienteRepositorio clienteRepositorio) {
		return new CrearClienteServicio(clienteRepositorio);
	}

}
