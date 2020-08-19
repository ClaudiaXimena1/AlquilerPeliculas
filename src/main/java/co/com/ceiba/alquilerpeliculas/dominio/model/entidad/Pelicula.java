package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

public class Pelicula {

	private Long id;
	private String nombre;
	private String genero;
	private String duracion;

	public Pelicula() {
		super();
	}

	public Pelicula(Long id, String nombre, String genero, String duracion) {
		super();
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
