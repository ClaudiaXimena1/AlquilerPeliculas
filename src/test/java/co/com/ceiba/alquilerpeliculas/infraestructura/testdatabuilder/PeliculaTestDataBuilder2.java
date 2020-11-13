package co.com.ceiba.alquilerpeliculas.infraestructura.testdatabuilder;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.PeliculaDto;

public class PeliculaTestDataBuilder2 {
	
	private String nombre;
	private String genero;
	private String duracion;
	
	public PeliculaTestDataBuilder2() {
		this.nombre = "Mision Imposible";
		this.genero = "Accion";
		this.duracion = "1 hora 45 minutos";
	}
	
	public PeliculaDto build() {
		return new PeliculaDto(nombre, genero, duracion);
	}

}
