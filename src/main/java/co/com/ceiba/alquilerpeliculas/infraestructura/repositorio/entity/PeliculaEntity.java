package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class PeliculaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "genero")
	private String genero;
	@Column(name = "duracion")
	private String duracion;

	public PeliculaEntity() {

	}

	public PeliculaEntity(Long id, String nombre, String genero, String duracion) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}

}
