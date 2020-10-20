package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pelicula {

	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre es un dato obligatorio.";
	private static final String EL_GENERO_ES_UN_DATO_OBLIGATORIO = "El genero es un dato obligatorio.";
	private static final String LA_DURACION_ES_UN_DATO_OBLIGATORIO = "La duracion es un dato obligatorio.";
	
	private Long id;
	private String nombre;
	private String genero;
	private String duracion;

	public Pelicula(Long id, String nombre, String genero, String duracion) {
		ValidadorAtributos.validarAtributos(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(genero, EL_GENERO_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(duracion, LA_DURACION_ES_UN_DATO_OBLIGATORIO);
		
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}
