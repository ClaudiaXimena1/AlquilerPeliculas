package co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;

public class PeliculaTestDataBuilder {
	
	private String nombre;
	private String genero;
	private String duracion;
	
	public PeliculaTestDataBuilder() {
		this.nombre = "Titanic";
		this.genero = "Drama";
		this.duracion = "3 horas";
	}
	
	public PeliculaDto build() {
		return new PeliculaDto(nombre, genero, duracion);
	}
	
	

}
