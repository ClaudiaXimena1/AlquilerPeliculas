package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "identificacion")
	private String identificacion;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono_fijo")
	private String telefonoFijo;
	@Column(name = "telefono_movil")
	private String telefonoMovil;
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PeliculaEntity> peliculaEntity;

}