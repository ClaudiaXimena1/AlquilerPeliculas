package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlquilerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name= "id_Cliente")
	private ClienteEntity clienteEntity;
	
	@ManyToOne
	@JoinColumn(name = "id_Pelicula")
	private PeliculaEntity peliculaEntity;

}
