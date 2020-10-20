package co.com.ceiba.alquilerpeliculas.dominio.model.dto;

import lombok.Getter;

@Getter
public class PeliculaDto {

	private String nombre;
	private String genero;
	private String duracion;

	public PeliculaDto() {
		super();
	}

	public PeliculaDto(String nombre, String genero, String duracion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}

}
