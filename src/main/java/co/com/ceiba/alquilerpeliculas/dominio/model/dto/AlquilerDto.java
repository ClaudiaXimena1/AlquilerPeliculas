package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AlquilerDto {

	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;

	@Autowired
	private Cliente cliente;

	@Autowired
	private Pelicula pelicula;	

}
