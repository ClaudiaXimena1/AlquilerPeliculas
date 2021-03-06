package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefonoFijo;
	private String telefonoMovil;
	private Date fechaRegistro;

	@OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.ALL)
	private List<AlquilerEntity> alquilerEntity;

}