package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AlquilerDto {

	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;

	@Autowired
	private ClienteDto clienteDto;

	@Autowired
	private PeliculaDto peliculaDto;	

}
