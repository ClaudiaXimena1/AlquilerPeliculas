package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PeliculaDto {

	private String nombre;
	private String genero;
	private String duracion;

}
