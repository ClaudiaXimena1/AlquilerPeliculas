package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PeliculaDto {

	private String nombre;
	private String genero;
	private String duracion;

}
