package co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;

public class PeliculaTestDataBuilder {
	
	private Long id;
	private String nombre;
	private String genero;
	private String duracion;
	
	public PeliculaTestDataBuilder() {
		this.id = (long) 3;
		this.nombre = "Titanic";
		this.genero = "Drama";
		this.duracion = "3 horas 50 minutos";
	}
	
	public PeliculaTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public PeliculaTestDataBuilder setGenero(String genero) {
		this.genero = genero;
		return this;
	}
	
	public PeliculaTestDataBuilder setDuracion(String duracion) {
		this.duracion = duracion;
		return this;
	}
	

	public Pelicula build() {
		return new Pelicula(id, nombre, genero, duracion);
	}

}
