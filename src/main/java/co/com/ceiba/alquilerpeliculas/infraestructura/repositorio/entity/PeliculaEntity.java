package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

	private String nombre;
	private String genero;
	private String duracion;
	
	@OneToOne(mappedBy = "peliculaEntity", cascade = CascadeType.ALL)
	private AlquilerEntity alquilerEntity;

	public PeliculaEntity() {

	}

	public PeliculaEntity(Long id, String nombre, String genero, String duracion, AlquilerEntity alquilerEntity) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.alquilerEntity = alquilerEntity;
	}

}
