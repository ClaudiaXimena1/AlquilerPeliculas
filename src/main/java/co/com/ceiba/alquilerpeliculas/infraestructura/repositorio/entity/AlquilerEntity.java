package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@Column(name = "fecha_Alquiler")
	private Date fechaAlquiler;
	@Column(name = "fecha_Entrega")
	private Date fechaEntrega;
	@Column(name = "valor")
	private Double valor;
	@Column(name = "fecha_Registro")
	private Date fechaRegistro;
	
	@OneToOne
	@JoinColumn(name= "id_Cliente")
	private ClienteEntity clienteEntity;
	
	@OneToOne
	@JoinColumn(name = "id_Pelicula")
	private PeliculaEntity peliculaEntity;

}
